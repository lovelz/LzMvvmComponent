package com.lz.module.home.data.repository;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.mvvm.base.manager.NetState;
import com.lz.mvvm.base.manager.NetworkStateManager;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class DataRepository implements IRemoteRequest, ILocalRequest {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    @Override
    public Disposable getNominateInfo(MutableLiveData<NominateInfo> liveData, int page) {
        return EasyHttp.get("/api/v5/index/tab/allRec?page=" + page)
                .cacheKey(getClass().getSimpleName() + "_NominateInfo")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                        NetworkStateManager.getInstance().networkStateCallback.postValue(new NetState("404", false));
                    }

                    @Override
                    public void onSuccess(String data) {
                        NominateInfo nominateInfo = GsonUtils.fromJson(data, NominateInfo.class);
                        liveData.postValue(nominateInfo);
                    }

                });

    }

    @Override
    public Disposable getDailyInfo(MutableLiveData<NominateInfo> liveData, int page) {
        return EasyHttp.get("/api/v5/index/tab/feed?num=" + page)
                .cacheKey(getClass().getSimpleName() + "_DailyInfo")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                        NetworkStateManager.getInstance().networkStateCallback.postValue(new NetState());
                    }

                    @Override
                    public void onSuccess(String data) {
                        liveData.postValue(GsonUtils.fromJson(data, NominateInfo.class));
                    }
                });
    }

    @Override
    public Disposable getDiscoverInfo(MutableLiveData<NominateInfo> liveData) {
        return EasyHttp.get("http://baobab.kaiyanapp.com/api/v7/index/tab/discovery?udid=fa53872206ed42e3857755c2756ab683fc22d64a&vc=591&vn=6.2.1&size=720X1280&deviceModel=Che1-CL20&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=19")
                .cacheKey(getClass().getSimpleName() + "_DailyInfo")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        NetworkStateManager.getInstance().networkStateCallback.postValue(new NetState());
                    }

                    @Override
                    public void onSuccess(String data) {
                        liveData.postValue(GsonUtils.fromJson(data, NominateInfo.class));
                    }
                });
    }

    public void cancel() {

    }

}
