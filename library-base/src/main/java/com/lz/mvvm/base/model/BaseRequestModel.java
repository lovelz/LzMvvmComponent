package com.lz.mvvm.base.model;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 主要为了统一取消订阅
 * author: lovelz
 * date: on 2020-07-03
 */
public class BaseRequestModel extends ViewModel {

    private CompositeDisposable compositeDisposable;

    /**
     * 添加订阅
     * @param disposable
     */
    protected void addDisposable(Disposable disposable) {
        if (disposable == null) {
            return;
        }
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 取消所有订阅
     */
    private void cancel() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        cancel();
    }
}
