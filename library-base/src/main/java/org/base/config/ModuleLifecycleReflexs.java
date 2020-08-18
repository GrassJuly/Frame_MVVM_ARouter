package org.base.config;

/**
 * Created by goldze on 2018/6/21 0021.
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * 注意：以下模块中初始化的Module类不能被混淆
 */

public class ModuleLifecycleReflexs {
    private static final String BaseInit = "org.base.base.BaseModuleInit";
    //主业务模块
    private static final String MainInit = "com.runjing.main.MainModuleInit";
    //登录验证模块
    private static final String SignInit = "com.runjing.sign.SignModuleInit";
    //首页业务模块
    private static final String HomeInit = "com.rujing.home.HomeModuleInit";
    //分类业务模块
    private static final String SortInit = "com.runjing.sort.SortModuleInit";
    //订单业务模块
    private static final String OrderInit = "com.runjing.order.OrderModuleInit";
    //用户业务模块
    private static final String UserInit = "com.runjing.user.UserModuleInit";
    //地图定位模块
    private static final String LocalInit = "com.runjing.local.LocalModuleInit";

    public static String[] initModuleNames = {BaseInit, MainInit, SignInit, HomeInit, SortInit, OrderInit, UserInit, LocalInit};
}
