package com.lz.mvvm.base.livedatabus;

import java.util.HashMap;
import java.util.Map;

import androidx.lifecycle.MutableLiveData;

/**
 * 基于liveData的事件总线
 * 1.关联activity / fragment 的生命周期 自动识别活动状态触发更新
 * 2.可以发送两种事件: 普通事件 & 粘性事件
 * author: lovelz
 * date: on 2020-06-08
 */
public class LiveDataBus {

    /**
     * 普通事件集合
     */
    private final Map<String, BusMutableLiveData> bus;

    /**
     * 粘性事件集合
     */
    private final Map<String, MutableLiveData> stickyBus;

    private LiveDataBus() {
        bus = new HashMap<>();
        stickyBus = new HashMap<>();
    }

    private static class singleHolder {
        private static final LiveDataBus SINGLE_BUS = new LiveDataBus();
    }

    public static LiveDataBus getInstance() {
        return singleHolder.SINGLE_BUS;
    }

    public MutableLiveData<Object> with(String key) {
        return with(key, Object.class);
    }

    private <T> MutableLiveData<T> with(String key, Class<T> type) {
        if (!bus.containsKey(key)) {
            bus.put(key, new BusMutableLiveData());
        }
        return bus.get(key);
    }

    public MutableLiveData<Object> withSticky(String key) {
        return withSticky(key, Object.class);
    }

    private <T> MutableLiveData<T> withSticky(String key, Class<T> type) {
        if (!stickyBus.containsKey(type)) {
            stickyBus.put(key, new MutableLiveData());
        }
        return stickyBus.get(key);
    }

}
