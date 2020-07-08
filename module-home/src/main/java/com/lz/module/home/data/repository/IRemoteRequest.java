package com.lz.module.home.data.repository;

import com.lz.module.home.data.bean.NominateInfo;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public interface IRemoteRequest {

    Disposable getNominateInfo(MutableLiveData<NominateInfo> liveData, int page);

    Disposable getDailyInfo(MutableLiveData<NominateInfo> liveData, int page);

    Disposable getDiscoverInfo(MutableLiveData<NominateInfo> liveData);

}
