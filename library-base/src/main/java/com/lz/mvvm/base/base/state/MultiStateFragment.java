package com.lz.mvvm.base.base.state;

import android.os.Bundle;
import android.view.View;

import com.lz.mvvm.base.base.AndroidXLazyFragment;
import com.lz.mvvm.base.model.BasePageModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 主要针对那些列表页面（包含列表为空页面）
 *
 * author: lovelz
 * date: on 2020-07-06
 */
public abstract class MultiStateFragment extends AndroidXLazyFragment {

    protected abstract BasePageModel getBasePageModel();

    /**
     * 请求分页数据
     *
     * @param changePage
     */
    protected abstract void requestData(int changePage);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBasePageModel().changePage.observe(getViewLifecycleOwner(), this::requestData);
    }

    @Override
    protected void lazyLoad() {
        getBasePageModel().changePage.setValue(0);
    }

    /**
     * 显示结果
     */
    protected void showResult(int listSize) {
        if (getBasePageModel().page == 0 && listSize == 0) {
            showEmpty();
        } else {
            showContent();
        }
    }

    @Override
    protected void onRetryBtnClick() {
        super.onRetryBtnClick();
        showLoading();
        getBasePageModel().changePage.setValue(0);
    }
}
