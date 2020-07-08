package com.lz.module.home.ui.page;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lz.module.home.BR;
import com.lz.module.home.R;
import com.lz.module.home.bridge.state.HomeViewModel;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.base.base.adapter.CommonFragmentPagerAdapter;
import com.lz.mvvm.common.router.RouterFragmentPath;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * 首页fragment
 *
 * author: lovelz
 * date: on 2020-06-11
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends MvvmBaseFragment {

    private HomeViewModel homeViewModel;

    @Override
    protected void initViewModel() {
        homeViewModel = getFragmentViewModel(HomeViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.home_fragment_home, homeViewModel, BR.vm)
                .addBindingParam(BR.adapter, new CommonFragmentPagerAdapter(getChildFragmentManager(),
                        getFragmentList(), new String[]{"发现", "推荐", "日报"}))
                .addBindingParam(BR.click, new ClickProxy());
    }

    private List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new NominateFragment());
        fragmentList.add(new DailyFragment());
        return fragmentList;
    }

    public class ClickProxy {

        public void candle() {
            ToastUtils.showShort("点我干嘛！");
        }

        public void search() {
            ToastUtils.showShort("搜索去咯！");
        }
    }

}
