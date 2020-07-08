package com.lz.mvvm.base.storage;

import com.tencent.mmkv.MMKV;

/**
 * 腾讯MMKV序列化存储工具类
 * author: lovelz
 * date: on 2020-06-08
 */
public class MmkvHelper {

    private static MMKV mmkv;

    private MmkvHelper() {
        mmkv = MMKV.defaultMMKV();
    }

    private static class MmkvHolder {
        private static final MmkvHelper INSTANCE = new MmkvHelper();
    }

    public static MmkvHelper getInstance() {
        return MmkvHolder.INSTANCE;
    }

    public MMKV getMmkv() {
        return mmkv;
    }

}
