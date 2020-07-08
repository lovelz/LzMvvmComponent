package com.lz.mvvm.base.activity;

/**
 * 界面UI显示切换
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public interface IBaseView {

    /**
     * 显示内容
     */
    void showContent();

    /**
     * 显示加载提示
     */
    void showLoading();

    /**
     * 显示空页面
     */
    void showEmpty();

    /**
     * 显示失败相关提示
     * @param msg
     */
    void showFailure(String msg);

}
