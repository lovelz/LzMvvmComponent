package com.lz.module.home.ui.binding;

import android.view.LayoutInflater;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lz.module.home.R;
import com.lz.module.home.databinding.HomeItemBannerViewBinding;
import com.lz.module.home.ui.page.adapter.DiscoverProviderAdapter;
import com.lz.module.home.ui.page.adapter.NominateProviderAdapter;
import com.lz.module.home.ui.page.adapter.provider.NetBannerProvider;
import com.orhanobut.logger.Logger;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class HomeRecyclerViewBindingAdapter {

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"nominateAdapter", "refreshList", "page"})
    public static void bindNominateAdapter(RecyclerView recyclerView, NominateProviderAdapter quickAdapter, List list, int page) {
        if (recyclerView != null && quickAdapter != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(quickAdapter);
            }
            if (!quickAdapter.hasHeaderLayout()) {
                ViewDataBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(recyclerView.getContext()),
                        R.layout.home_item_banner_view,
                        recyclerView,
                        false);
                quickAdapter.addHeaderView(binding.getRoot());
                ArrayList<String> list1 = new ArrayList<>();
                list1.add(
                        "http://img.kaiyanapp.com/b5b00c67dfc759a02c8b457e104b3ec6.png?imageMogr2/quality/60/format/jpg");
                list1.add(
                        "http://img.kaiyanapp.com/b5b00c67dfc759a02c8b457e104b3ec6.png?imageMogr2/quality/60/format/jpg");
                list1.add(
                        "http://img.kaiyanapp.com/1eaf8827688ea3b910b7b6b6cb192a5f.png?imageMogr2/quality/60/format/jpg");
                list1.add(
                        "http://img.kaiyanapp.com/1eaf8827688ea3b910b7b6b6cb192a5f.png?imageMogr2/quality/60/format/jpg");

                ((HomeItemBannerViewBinding) binding).bannerView
                        .setHolderCreator(NetBannerProvider::new)
                        .create(list1);
            }

            if (page == 0) {
                quickAdapter.setNewData(list);
            } else {
                quickAdapter.addData(list);
            }

            if (recyclerView.getParent() instanceof SmartRefreshLayout) {
                ((SmartRefreshLayout) recyclerView.getParent()).finishRefresh();
                ((SmartRefreshLayout) recyclerView.getParent()).finishLoadMore();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"discoverAdapter", "refreshList"})
    public static void bindDiscoverAdapter(RecyclerView recyclerView, DiscoverProviderAdapter quickAdapter, List list) {
        if (recyclerView != null && quickAdapter != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(quickAdapter);
            }
            if (!quickAdapter.hasFooterLayout()) {
                ViewDataBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(recyclerView.getContext()),
                        R.layout.home_item_discover_footer_view,
                        recyclerView,
                        false);
                quickAdapter.addFooterView(binding.getRoot());
            }

            //set list data
            quickAdapter.setNewData(list);

            if (recyclerView.getParent() instanceof SmartRefreshLayout) {
                ((SmartRefreshLayout) recyclerView.getParent()).finishRefresh();
            }
        }
    }

}
