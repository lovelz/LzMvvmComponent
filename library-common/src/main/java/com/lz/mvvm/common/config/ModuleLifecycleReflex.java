package com.lz.mvvm.common.config;

/**
 * 组件生命周期初始化类的类目管理者，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 *
 * author: lovelz
 * date: on 2020-06-08
 */
public class ModuleLifecycleReflex {

    /** 基础库 **/
    private static final String BaseInit = "com.lz.mvvm.common.CommonModuleInit";

    /** main组件库 **/
    private static final String MainInit = "com.lz.module.main.application.MainModuleInit";

    public static String[] initModuleNames = {BaseInit, MainInit};

}
