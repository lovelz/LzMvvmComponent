package com.lz.mvvm.base.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.blankj.utilcode.util.NetworkUtils;

import java.util.Objects;

/**
 * author: lovelz
 * date: on 2020-06-24
 */
public class NetworkStateReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (!NetworkUtils.isConnected()) {
                NetState netState = new NetState();
                netState.setSuccess(false);
                netState.setResponseCode("404");
                NetworkStateManager.getInstance().networkStateCallback.postValue(netState);

            }
        }
    }
}
