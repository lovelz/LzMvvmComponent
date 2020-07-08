package com.lz.mvvm.base.activity;

/**
 * 存在那些分页加载的页面
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public interface IBasePagingView extends IBaseView {

    /**
     * 加载更多失败
     * @param msg
     */
    void onLoadMoreFailure(String msg);

    /**
     * 没有更多了
     */
    void onLoadMoreEmpty();

}
