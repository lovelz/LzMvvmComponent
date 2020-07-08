package com.lz.module.home.ui.page;

import android.os.Bundle;
import android.view.View;

import com.lz.module.home.BR;
import com.lz.module.home.R;
import com.lz.module.home.bridge.request.HomeRequestModel;
import com.lz.module.home.bridge.state.DailyViewModel;
import com.lz.module.home.ui.page.adapter.DailyProviderAdapter;
import com.lz.mvvm.base.base.AndroidXLazyFragment;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.base.base.MvvmLazyFragment;
import com.lz.mvvm.base.event.EventHandler;
import com.lz.mvvm.base.model.BasePageModel;
import com.orhanobut.logger.Logger;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 日报页
 *
 * author: lovelz
 * date: on 2020-06-11
 */
public class DailyFragment extends AndroidXLazyFragment {

    private DailyViewModel dailyViewModel;
    private HomeRequestModel homeRequestModel;

    @Override
    protected void initViewModel() {
        dailyViewModel = getFragmentViewModel(DailyViewModel.class);
        homeRequestModel = getFragmentViewModel(HomeRequestModel.class);
    }

    @Override
    protected int getLoadSirViewId() {
        return R.id.refresh_layout;
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.home_fragment_daily, dailyViewModel, BR.vm)
                .addBindingParam(BR.adapter, new DailyProviderAdapter())
                .addBindingParam(BR.event, new EventHandler(dailyViewModel));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeRequestModel.getDailyLiveData().observe(getViewLifecycleOwner(), nominateInfo -> {
            if (nominateInfo != null && nominateInfo.getItemList() != null) {
                showContent();
                dailyViewModel.refreshList.setValue(nominateInfo.getItemList());
            }
        });

        dailyViewModel.changePage.observe(getViewLifecycleOwner(), changePage ->
                homeRequestModel.requestDailyInfo(dailyViewModel.page));

    }

    @Override
    protected void lazyLoad() {
        dailyViewModel.changePage.setValue(0);
    }

}
