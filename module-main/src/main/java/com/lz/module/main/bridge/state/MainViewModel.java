package com.lz.module.main.bridge.state;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel 的职责仅限于 状态托管，不建议在此处理 UI 逻辑，UI 逻辑只适合在 Activity/Fragment 等视图控制器中完成，是 “数据驱动” 的一部分，
 *
 * author: lovelz
 * date: on 2020-06-11
 */
public class MainViewModel extends ViewModel {
    /**
     * 使用ObservableField具有防抖的特点，比如第一次设置true后收到通知，再设置true则不会收到通知
     */
    public final ObservableBoolean initMainPageNavigation = new ObservableBoolean();

    {
        initMainPageNavigation.set(true);
    }

}
