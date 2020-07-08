package com.lz.mvvm.common.router;

/**
 * 用于组件化开发中,ARouter Fragment路径统一注册, 注册的路径请写好注释、标注业务功能
 *
 * author: lovelz
 * date: on 2020-06-08
 */
public class RouterFragmentPath {

    /**
     * 首页组件
     */
    public static class Home {

        private static final String HOME = "/home";

        /**
         * 首页
         */
        public static final String PAGER_HOME = HOME + "/Home";

    }

    /**
     * 社区组件
     */
    public static class Community {

        private static final String COMMUNITY = "/community";

        /**
         * 社区页
         */
        public static final String PAGER_COMMUNITY = COMMUNITY + "/Community";

    }

    /**
     * 更多组件
     */
    public static class More {

        private static final String MORE = "/more";

        /**
         * 更多页
         */
        public static final String PAGER_MORE = MORE + "/More";

    }

    /**
     * 个人中心组件
     */
    public static class User {

        private static final String USER = "/user";

        /**
         * 个人中心页
         */
        public static final String PAGER_USER = USER + "/User";

    }

}
