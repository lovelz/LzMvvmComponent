package com.lz.open.lzmvvmcomponent;

import com.lz.mvvm.base.base.BaseApplication;
import com.lz.mvvm.common.config.ModuleLifecycleConfig;

/**
 * 宿主APP
 *
 * 宿主app的 application ,在这里通过common组件中定义的组件生命周期配置类进行相应初始化(通过反射调用各个组件的初始化器)
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public class Application extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        setsDebug(BuildConfig.DEBUG);
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}
