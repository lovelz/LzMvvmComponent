package com.lz.module.home.bridge.state;

import com.lz.module.home.data.bean.NominateInfo;
import com.lz.mvvm.base.model.BasePageModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * author: lovelz
 * date: on 2020-06-12
 */
public class NominateViewModel extends BasePageModel {

    public MutableLiveData<List<NominateInfo.ItemListBeanX>> refreshList = new MutableLiveData<>();

}
