package com.lz.module.home.bridge.request;

import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.data.repository.DataRepository;
import com.lz.mvvm.base.model.BaseRequestModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class HomeRequestModel extends BaseRequestModel {

    private MutableLiveData<NominateInfo> mNominateLiveData;

    private MutableLiveData<NominateInfo> mDailyLiveData;

    private MutableLiveData<NominateInfo> mDiscoverLiveData;

    public LiveData<NominateInfo> getNominateLiveData() {
        if (mNominateLiveData == null) {
            mNominateLiveData = new MutableLiveData<>();
        }
        return mNominateLiveData;
    }

    public LiveData<NominateInfo> getDailyLiveData() {
        if (mDailyLiveData == null) {
            mDailyLiveData = new MutableLiveData<>();
        }
        return mDailyLiveData;
    }

    public LiveData<NominateInfo> getDiscoverLiveData() {
        if (mDiscoverLiveData == null) {
            mDiscoverLiveData = new MutableLiveData<>();
        }
        return mDiscoverLiveData;
    }

    public void requestNominateInfo(int page) {
        addDisposable(DataRepository.getInstance().getNominateInfo(mNominateLiveData, page));
    }

    public void requestDailyInfo(int page) {
        addDisposable(DataRepository.getInstance().getDailyInfo(mDailyLiveData, page));
    }

    public void requestDiscoverInfo() {
        addDisposable(DataRepository.getInstance().getDiscoverInfo(mDiscoverLiveData));
    }

}
