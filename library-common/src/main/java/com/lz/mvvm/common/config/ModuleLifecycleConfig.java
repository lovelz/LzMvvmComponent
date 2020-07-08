package com.lz.mvvm.common.config;

import com.lz.mvvm.base.base.BaseApplication;
import com.lz.mvvm.common.IModuleInit;

import androidx.annotation.Nullable;

/**
 * 各个组件生命周期初始化的配置类，通过反射机制，动态调用每个组件初始化逻辑
 *
 * author: lovelz
 * date: on 2020-06-08
 */
public class ModuleLifecycleConfig {

    private ModuleLifecycleConfig() {

    }

    private static class SingleHolder {
        private static ModuleLifecycleConfig instance = new ModuleLifecycleConfig();
    }

    public static ModuleLifecycleConfig getInstance() {
        return SingleHolder.instance;
    }

    /** 优先初始化 */
    public void initModuleAhead(@Nullable BaseApplication application) {
        for (String moduleName : ModuleLifecycleReflex.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                init.onInitAhead(application);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    /** 后初始化 */
    public void initModuleLow(@Nullable BaseApplication application) {
        for (String moduleName : ModuleLifecycleReflex.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                init.onInitAhead(application);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

}
