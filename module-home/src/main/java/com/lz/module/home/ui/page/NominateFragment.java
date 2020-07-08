package com.lz.module.home.ui.page;

import android.os.Bundle;
import android.view.View;

import com.lz.module.home.BR;
import com.lz.module.home.R;
import com.lz.module.home.bridge.request.HomeRequestModel;
import com.lz.module.home.bridge.state.NominateViewModel;
import com.lz.module.home.ui.page.adapter.NominateProviderAdapter;
import com.lz.mvvm.base.base.AndroidXLazyFragment;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.state.MultiStateFragment;
import com.lz.mvvm.base.event.EventHandler;
import com.lz.mvvm.base.model.BasePageModel;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 推荐页
 *
 * author: lovelz
 * date: on 2020-06-11
 */
public class NominateFragment extends MultiStateFragment {

    private NominateViewModel nominateViewModel;
    private HomeRequestModel homeRequestModel;

    @Override
    protected void initViewModel() {
        nominateViewModel = getFragmentViewModel(NominateViewModel.class);
        homeRequestModel = getFragmentViewModel(HomeRequestModel.class);
    }

    @Override
    protected BasePageModel getBasePageModel() {
        return nominateViewModel;
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.home_fragment_nominate, nominateViewModel, BR.vm)
                .addBindingParam(BR.adapter, new NominateProviderAdapter())
                .addBindingParam(BR.event, new EventHandler(nominateViewModel));
    }

    @Override
    protected int getLoadSirViewId() {
        return R.id.refresh_layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //request data and set data
        homeRequestModel.getNominateLiveData().observe(getViewLifecycleOwner(), nominateInfo -> {
            if (nominateInfo != null && nominateInfo.getItemList() != null) {
                nominateViewModel.refreshList.setValue(nominateInfo.getItemList());
                showResult(nominateInfo.getItemList().size());
            }
        });

    }

    @Override
    protected void requestData(int changePage) {
        homeRequestModel.requestNominateInfo(changePage);
    }

}
