package com.lz.mvvm.base.manager;

/**
 * author: lovelz
 * date: on 2020-06-24
 */
public class NetState {

    private String responseCode;
    private boolean success = true;

    public NetState() {
    }

    public NetState(String responseCode, boolean success) {
        this.responseCode = responseCode;
        this.success = success;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
