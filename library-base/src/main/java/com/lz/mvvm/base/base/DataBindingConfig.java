package com.lz.mvvm.base.base;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

/**
 * 将DataBinding实例限制于base页面中，默认不向子类暴露
 *
 * author: lovelz
 * date: on 2020-06-09
 */
public class DataBindingConfig {

    private int layout;

    private ViewModel stateViewModel;

    private int stateViewModelId;

    private SparseArray bindingParams = new SparseArray();

    public DataBindingConfig(int layout) {
        this.layout = layout;
    }

    public DataBindingConfig(int layout, ViewModel stateViewModel, int stateViewModelId) {
        this.layout = layout;
        this.stateViewModel = stateViewModel;
        this.stateViewModelId = stateViewModelId;
    }

    public int getLayout() {
        return layout;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public int getStateViewModelId() {
        return stateViewModelId;
    }

    public SparseArray getBindingParams() {
        return bindingParams;
    }

    public DataBindingConfig addBindingParam(int variableId, Object object) {
        if (bindingParams.get(variableId) == null) {
            bindingParams.append(variableId, object);
        }
        return this;
    }

}
