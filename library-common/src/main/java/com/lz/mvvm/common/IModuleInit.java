package com.lz.mvvm.common;

import com.lz.mvvm.base.base.BaseApplication;

/**
 * 动态配置组件Application，有需要初始化的组件实现该接口，统一在宿主app的Application进行初始化
 *
 * author: lovelz
 * date: on 2020-06-08
 */
public interface IModuleInit {

    /**
     * 需要优先初始化的
     * @param application
     * @return
     */
    boolean onInitAhead(BaseApplication application);

    /**
     * 以后可以初始化的
     * @param application
     * @return
     */
    boolean onInitLow(BaseApplication application);

}
