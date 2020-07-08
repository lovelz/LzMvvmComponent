package com.lz.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.lz.mvvm.base.R;

/**
 * 错误页面
 *
 * author: lovelz
 * date: on 2020-06-05
 */
public class ErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.base_layout_error;
    }
}
