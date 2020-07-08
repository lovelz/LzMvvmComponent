package com.lz.mvvm.base.base;

import com.orhanobut.logger.Logger;

/**
 * Android X 下 ViewPager + Fragment下懒加载
 * 在 FragmentPagerAdapter 与 FragmentStatePagerAdapter 新增了含有 behavior 字段的构造函数,可以限制状态，懒加载很好实现
 *
 * author: lovelz
 * date: on 2020-07-01
 */
public abstract class AndroidXLazyFragment extends MvvmBaseFragment {

    private boolean isFirstLoaded = false;

    @Override
    public void onResume() {
        super.onResume();

        if (!isFirstLoaded) {
            isFirstLoaded = true;
            lazyLoad();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //当使用了FragmentPagerAdapter，fragment实例并不会摧毁，只会移除view，走事务上的detach,只能走到这儿
        //所以在这重新初始化
        isFirstLoaded = false;
    }

    protected abstract void lazyLoad();
}
