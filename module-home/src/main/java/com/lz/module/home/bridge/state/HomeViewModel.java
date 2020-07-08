package com.lz.module.home.bridge.state;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

/**
 * author: lovelz
 * date: on 2020-06-11
 */
public class HomeViewModel extends ViewModel {

    public final ObservableInt initPagePosition = new ObservableInt();

    {
        initPagePosition.set(1);
    }

}
