package org.base.router;

/**
 * 用于组件开发中，ARouter多Fragment跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 * Created by goldze on 2018/6/21
 */

public class RouterFragmentPath {
    /**
     * 首页组件
     */
    public static class Home {
        private static final String HOME = "/home";
        /*首页*/
        public static final String PAGER_HOME = HOME + "/Home";
    }

    /**
     * 分类组件
     */
    public static class Sort {
        private static final String WORK = "/sort";
        /*f分类*/
        public static final String PAGER_SORT = WORK + "/Sort";
    }

    /**
     * 订单组件
     */
    public static class Order {
        private static final String MSG = "/order";
        /*订单*/
        public static final String PAGER_ORDER = MSG + "/Order";
    }

    /**
     * 用户组件
     */
    public static class User {
        private static final String USER = "/user";
        /*我的*/
        public static final String PAGER_MINE = USER + "/Mine";
    }
}
