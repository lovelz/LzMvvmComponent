package com.lz.module.main.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.lz.module.main.BR;
import com.lz.module.main.R;
import com.lz.module.main.bridge.state.MainViewModel;
import com.lz.module.main.ui.adapter.MainPageAdapter;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseActivity;
import com.lz.mvvm.base.storage.MmkvHelper;
import com.lz.mvvm.common.router.RouterActivityPath;
import com.lz.mvvm.common.router.RouterFragmentPath;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 主页面
 * <p>
 * author: lovelz
 * date: on 2020-06-09
 */
@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends MvvmBaseActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void initViewModel() {
        mainViewModel = getActivityViewModel(MainViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.main_activity_main, mainViewModel, BR.vm)
                .addBindingParam(BR.adapter, new MainPageAdapter(getSupportFragmentManager(), getFragmentList()));
    }

    public static void start(Context context) {
        MmkvHelper.getInstance().getMmkv().encode("first", false);
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImmersionBar.with(this)
                .statusBarColor(R.color.main_color_bar)
                .navigationBarColor(R.color.main_color_bar)
                .fitsSystemWindows(true)
                .autoDarkModeEnable(true)
                .init();

        initView();

    }

    private void initView() {

    }

    private List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        //通过ARouter获取其它模块提供的fragment
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
        Fragment communityFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Community.PAGER_COMMUNITY).navigation();
        Fragment moreFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.More.PAGER_MORE).navigation();
        Fragment userFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.User.PAGER_USER).navigation();
        fragmentList.add(homeFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(moreFragment);
        fragmentList.add(userFragment);
        return fragmentList;
    }

}
