package com.lz.mvvm.base.event;

import com.lz.mvvm.base.model.BasePageModel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import androidx.annotation.NonNull;

/**
 * 统一的下拉加载刷新方法
 * 记得所对应的ViewModel 继承 {@link BasePageModel},里面也没有过度的操作
 *
 * 一切为了省事\(^o^)/~
 *
 * author: lovelz
 * date: on 2020-07-02
 */
public class EventHandler implements OnRefreshLoadMoreListener {

    private BasePageModel pageModel;

    public EventHandler(BasePageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pageModel.changePage.setValue(++pageModel.page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pageModel.page = 0;
        pageModel.changePage.setValue(0);
    }
}
