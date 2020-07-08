package com.lz.mvvm.base.base;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * 懒加载的fragment
 *
 * author: lovelz
 * date: on 2020-06-05
 */
public abstract class MvvmLazyFragment extends MvvmBaseFragment {

    private String TAG = getClass().getSimpleName();

    /**
     * Fragment生命周期 onAttach -> onCreate -> onCreatedView -> onActivityCreated -> onStart ->
     * onResume -> onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
     * 对于 ViewPager + Fragment 的实现我们需要关注以下几个生命周期：onCreatedView、OnActivityCreate、onResume、onPause、onDestroyView
     */

    private View rootView = null;

    /**
     * 布局是否创建完成
     */
    private boolean isViewCreated = false;

    /**
     * 当前可见状态
     */
    private boolean currentVisibleState = false;

    /**
     * 是否第一次可见
     */
    protected boolean isFirstVisible = true;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Logger.t(TAG).i("OnAttach--");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.t(TAG).i("onCreateView--");
        if (rootView == null) {
            DataBindingConfig dataBindingConfig = getDataBindingConfig();

            ViewDataBinding binding = DataBindingUtil.inflate(inflater, dataBindingConfig.getLayout(), container, false);
            binding.setLifecycleOwner(this);
            binding.setVariable(dataBindingConfig.getStateViewModelId(), dataBindingConfig.getStateViewModel());
            SparseArray bindingParams = dataBindingConfig.getBindingParams();
            for (int i = 0, length = bindingParams.size(); i < length; i++) {
                binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
            }
            rootView = binding.getRoot();


            //初始化LoadSir
            if (getLoadSirViewId() != -1) {
                setLoadSir(binding.getRoot().findViewById(getLoadSirViewId()));
                showLoading();
            }

        }
        isViewCreated = true;
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.t(TAG).i("onViewCreated--");

        //初始化的时候，判断当前Fragment的可见状态
        //isHidden()在使用FragmentTransaction的show/hidden时会调用，可见返回的是false
        if (!isHidden() && getUserVisibleHint()) {
            //可见状态
            dispatchChildVisibleState(true);
        }
    }

    /**
     * Fragment可见性发生改变，被调用有以下两种情况：
     * 1、在切换tab的时候（ViewPage），会先于fragment的其它生命周期，先调用这个方法
     * 2、对于之前已经调用过setUserVisibleHint方法的fragment后，让fragment从可见到不可见之间状态的变化
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Logger.t(TAG).i("setUserVisibleHint-- %s", isVisibleToUser);
        //对于情况1不予处理，用isViewCreated来判断，如果isViewCreated为false，则表明它没有被创建
        if (isViewCreated) {
            //对于情况2，需要分情况
            //2.1、从不可见 -> 可见：首先必须是可见的（isVisibleToUser为true），而且只有当可见状态进行改变的时候才需要切换，否则会出现反复调用的情况
            //2.2、从可见 -> 不可见：没啥事
            if (isVisibleToUser && !currentVisibleState) {
                dispatchUserVisibleHint(true);
            } else if (!isVisibleToUser && currentVisibleState) {
                dispatchUserVisibleHint(false);
            }
        }
    }

    /**
     * 用FragmentTransaction来控制fragment的hide和show时，这个方法会被调用
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Logger.t(TAG).i("onHiddenChanged-- %s", hidden);
        if (hidden) {
            //不可见
            dispatchUserVisibleHint(false);
        } else {
            //可见
            dispatchUserVisibleHint(true);
        }
    }

    /**
     * 统一处理用户可见事件分发
     * @param isVisible
     */
    private void dispatchUserVisibleHint(boolean isVisible) {
        Logger.t(TAG).i("dispatchUserVisibleHint-- %s", isVisible);

        //首先考虑fragment嵌套fragment的情况（只考虑两层嵌套）
        if (isVisible && isParentInvisible()) {
            //父view此时不可见
            return;
        }
        //状态一致则不需要处理了
        if (currentVisibleState == isVisible) {
            return;
        }
        currentVisibleState = isVisible;
        if (isVisible) {
            if (isFirstVisible) {
                isFirstVisible = false;
                //第一次可见
                onFragmentFirstVisible();
            }
            onFragmentResume();
            //分发事件给内嵌的fragment
            dispatchChildVisibleState(true);
        } else {
            onFragmentPause();
            dispatchChildVisibleState(false);
        }
    }

    /**
     * 在双重ViewPager嵌套的情况下，第一次滑到Frgment 嵌套ViewPager(fragment)的场景的时候
     * 此时只会加载外层Fragment的数据，而不会加载内嵌viewPager中的fragment的数据，因此，我们
     * 需要在此增加一个当外层Fragment可见的时候，分发可见事件给自己内嵌的所有Fragment显示
     */
    private void dispatchChildVisibleState(boolean visible) {
        Logger.t(TAG).i("dispatchChildVisibleState-- %s", visible);

        FragmentManager fm = getChildFragmentManager();
        List<Fragment> fragmentList = fm.getFragments();
        if (fragmentList.size() > 0) {
            for (Fragment fragment : fragmentList) {
                if (fragment instanceof MvvmLazyFragment && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                    ((MvvmLazyFragment) fragment).dispatchUserVisibleHint(visible);
                }
            }
        }
    }

    /**
     * 第一次可见，具体业务具体操作
     */
    protected void onFragmentFirstVisible() {
        Logger.t(TAG).i("onFragmentFirstVisible-- ");

    }

    /**
     * 可见时的Resume,可以进行一些耗时操作
     */
    protected void onFragmentResume() {

    }

    protected void onFragmentPause() {

    }

    /**
     * 判断上一级view隐藏显示状态
     * @return
     */
    private boolean isParentInvisible() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MvvmLazyFragment) {
            MvvmLazyFragment fragment = (MvvmLazyFragment) parentFragment;
            return !fragment.isSupportVisible();
        }
        return false;
    }

    private boolean isSupportVisible() {
        return currentVisibleState;
    }

    /**
     * 在滑动或者跳转的时候，第一次创建fragment的时候均会调用onResume方法
     * 当Activity生命周期发生变化是，自己所拥有的fragment都会执行这个变化，会造成不必要的消耗
     */
    @Override
    public void onResume() {
        super.onResume();
        //不是第一次可见
        if (!isFirstVisible) {
            //只执行可见的Fragment进行加载
            if (!isHidden() && !currentVisibleState && getUserVisibleHint()) {
                dispatchUserVisibleHint(true);
            }
        }
    }

    /**
     * 只有当前fragment有可见到不可见状态才需要调用
     */
    @Override
    public void onPause() {
        super.onPause();
        if (currentVisibleState && getUserVisibleHint()) {
            dispatchUserVisibleHint(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;

        Logger.t(TAG).i("onDestroyView-- ");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.t(TAG).i("onDetach-- ");
    }
}
