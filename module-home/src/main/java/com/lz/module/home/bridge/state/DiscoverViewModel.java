package com.lz.module.home.bridge.state;

import com.lz.module.home.data.bean.NominateInfo;
import com.lz.mvvm.base.model.BasePageModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

/**
 * author: lovelz
 * date: on 2020-07-02
 */
public class DiscoverViewModel extends BasePageModel {

    public MutableLiveData<List<NominateInfo.ItemListBeanX>> refreshList = new MutableLiveData<>();

}
