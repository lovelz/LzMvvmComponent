package com.lz.mvvm.base.base;

import android.app.usage.NetworkStatsManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.lz.mvvm.base.loadsir.EmptyCallback;
import com.lz.mvvm.base.loadsir.ErrorCallback;
import com.lz.mvvm.base.loadsir.LoadingCallback;
import com.lz.mvvm.base.manager.NetState;
import com.lz.mvvm.base.manager.NetworkStateManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * mvvm activity 基类
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public abstract class MvvmBaseActivity extends AppCompatActivity {

    protected LoadService mLoadService;

    private ViewModelProvider mActivityProvider;

    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBindingConfig();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(NetworkStateManager.getInstance());

        initViewModel();
        DataBindingConfig dataBindingConfig = getDataBindingConfig();

        //TODO tip: DataBinding 严格模式：
        // 将 DataBinding 实例限制于 base 页面中，默认不向子类暴露，
        // 通过这样的方式，来彻底解决 视图调用的一致性问题，
        // 如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。

        ViewDataBinding binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());
        binding.setLifecycleOwner(this);
        binding.setVariable(dataBindingConfig.getStateViewModelId(), dataBindingConfig.getStateViewModel());
        SparseArray bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }

        //初始化LoadSir
        if (getLoadSirViewId() != -1) {
            setLoadSir(binding.getRoot().findViewById(getLoadSirViewId()));
            showLoading();
        }

        //TODO 注意 liveData 的 lambda 回调中不可为空，不然会出现 Cannot add the same observer with different lifecycles 的现象，
        NetworkStateManager.getInstance().networkStateCallback.observe(this, this::onNetworkStateChanged);

    }

    @SuppressWarnings("EmptyMethod")
    protected void onNetworkStateChanged(NetState netState) {
        //TODO 子类可以重写该方法，统一的网络状态通知和处理
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    private boolean isShowedContent = false;

    /**
     * 选择将LoadSir状态管理依附在哪个view id上
     * @return -1:不添加状态管理，other:添加状态管理
     */
    protected int getLoadSirViewId() {
        return -1;
    }

    private void setLoadSir(View view) {
        if (mLoadService == null) {
            mLoadService = LoadSir.getDefault()
                    .register(view, (Callback.OnReloadListener) v -> onRetryBtnClick());
        }
    }

    public void showContent() {
        if (mLoadService != null) {
            isShowedContent = true;
            mLoadService.showSuccess();
        }
    }

    public void showLoading() {
        if (mLoadService != null) {
            mLoadService.showCallback(LoadingCallback.class);
        }
    }

    public void showEmpty() {
        if (mLoadService != null) {
            mLoadService.showCallback(EmptyCallback.class);
        }
    }

    public void showFailure(String msg) {
        if (mLoadService != null) {
            if (!isShowedContent) {
                mLoadService.showCallback(ErrorCallback.class);
            } else {
                ToastUtils.showShort(msg);
            }
        }
    }

    /**
     * 重新加载事件
     */
    protected void onRetryBtnClick(){

    }


}
