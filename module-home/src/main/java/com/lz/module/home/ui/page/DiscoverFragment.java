package com.lz.module.home.ui.page;

import android.os.Bundle;
import android.view.View;

import com.lz.module.home.BR;
import com.lz.module.home.R;
import com.lz.module.home.bridge.request.HomeRequestModel;
import com.lz.module.home.bridge.state.DiscoverViewModel;
import com.lz.module.home.ui.page.adapter.DiscoverProviderAdapter;
import com.lz.mvvm.base.base.AndroidXLazyFragment;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.base.event.EventHandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 发现页
 *
 * author: lovelz
 * date: on 2020-06-11
 */
public class DiscoverFragment extends AndroidXLazyFragment {

    private DiscoverViewModel discoverViewModel;
    private HomeRequestModel requestModel;

    @Override
    protected void initViewModel() {
        discoverViewModel = getFragmentViewModel(DiscoverViewModel.class);
        requestModel = getFragmentViewModel(HomeRequestModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.home_fragment_discover, discoverViewModel, BR.vm)
                .addBindingParam(BR.adapter, new DiscoverProviderAdapter())
                .addBindingParam(BR.event, new EventHandler(discoverViewModel));
    }

    @Override
    protected int getLoadSirViewId() {
        return R.id.refresh_layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requestModel.getDiscoverLiveData().observe(getViewLifecycleOwner(), nominateInfo -> {
            if (nominateInfo != null && nominateInfo.getItemList() != null) {
                showContent();
                discoverViewModel.refreshList.setValue(nominateInfo.getItemList());
            }
        });

        discoverViewModel.changePage.observe(getViewLifecycleOwner(), changePage -> {
            requestModel.requestDiscoverInfo();
        });
    }

    @Override
    protected void lazyLoad() {
        if (requestModel.getDiscoverLiveData().getValue() == null) {
            discoverViewModel.changePage.setValue(0);
        }
    }
}
