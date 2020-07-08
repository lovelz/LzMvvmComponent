package com.lz.mvvm.base.base;

import android.app.Activity;

import java.util.Stack;

/**
 * 应用内Activity栈管理
 *
 * author: lovelz
 * date: on 2020-06-04
 */
public class AppManager {

    private static Stack<Activity> activityStack;

    private AppManager() {

    }

    private static class SingleHolder {
        private static AppManager instance = new AppManager();
    }

    /**
     * 单例
     * @return
     */
    public static AppManager getInstance() {
        return SingleHolder.instance;
    }

    /**
     * 添加Activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 移除Activity
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 是否存在Activity
     * @return
     */
    public boolean isActivity() {
        if (activityStack != null) {
            return !activityStack.empty();
        }
        return false;
    }

    /**
     * 获取当前Activity
     * @return
     */
    public Activity currentActivity() {
        if (activityStack != null && activityStack.size() != 0) {
            return activityStack.lastElement();
        }
        return null;
    }

    /**
     * 结束指定的Activity
     * @param activity
     */
    private void finishActivity(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) activity.finish();
        }
    }

    private void finishAllActivity() {
        if (activityStack == null) return;

        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (activityStack.get(i) != null) {
                finishActivity(activityStack.get(i));
            }
        }
        activityStack.clear();
    }

    /**
     * 退出APP
     */
    public void AppExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
            activityStack.clear();
            e.printStackTrace();
        }
    }

}
