package com.lz.mvvm.common.adapter;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import androidx.databinding.BindingAdapter;

/**
 * author: lovelz
 * date: on 2020-06-23
 */
public class SmartRefreshBindingAdapter {

    @BindingAdapter(value = {"onRefreshLoadMoreListener"})
    public static void onRefreshLoadMoreListener(SmartRefreshLayout refreshLayout, OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        refreshLayout.setOnRefreshLoadMoreListener(onRefreshLoadMoreListener);
    }

}
