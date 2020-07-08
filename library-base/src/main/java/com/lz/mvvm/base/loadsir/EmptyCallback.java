package com.lz.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.lz.mvvm.base.R;

/**
 * 空页面
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.base_layout_empty;
    }

}
