package org.base.config;

import android.Manifest;

/**
 * @Created by xiaoyu on 2017/1/6.
 * @Describe：公共常量
 * @Review by：
 * @Modify by：
 * @Version : $ v_1.0 on 2017/1/6.
 * @Remark:
 */
public class Appconfig {
    //http
    public static String LoginSuccess = "113";//登录  请求成功8
    public static String RequestSuccess = "200";//网络 请求成功
    public static String LoadMorePageSize = "15";//请求数据条数
    public static String RESPONSE_CODE_RESULTS = "100";//数据查询有数据
    public static String RESPONSE_CODE_NO_DATA = "110";//数据查询无数据
    public static String RESPONSE_CODE_NORESULTS = "101";//数据查询 无数据
    public static String ACCOUNT_REPEAT = "3008";//账户重复，请联系客服
    public static String CONTENT_KEY = "rj_content_key";
    public static String DATA_KEY = "rj_data_key";
    public static final int DEFAULT_VALUES = -1000;//默认 数据
    public static int DEFAULT_VALUE_LONG = 1;
    public static String TAG = "runjing";
    public static final String FROMREGIST = "https%3a%2f%2fplogin.m.jd.com%2fuser%2flogin.action%3fappid%3d100%26returnurl%3dregist.openApp.jdMobile%3a%2f%2fcommunication";
    public static final int pageSize = 10;

    private static String BACKGROUND_LOCATION_PERMISSION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET,
            BACKGROUND_LOCATION_PERMISSION
    };

    public static String[] needINTENTPermissions = {
            Manifest.permission.INTERNET,
    };

    /*项目中常用参数*/
    public static final int APPCONFIG_ONE = 1;
    public static final int APPCONFIG_TWO = 2;

    //本地缓存变量
    public static final String User = "user_name";
    public static final String PassWord = "password";
    public static final String Phone = "phone";
    public static final String IS_AGREE = "is_agree";
    public static final String IS_GUILD = "is_guild";
    public static final String lon = "lon";
    public static final String currentlon = "currentlon";
    public static final String lat = "lat";
    public static final String currentlat = "currentlat";
    public static final String city = "city";
    public static final String address = "address";
    public static final String CurAddress = "curaddress";
    public static final String poiName = "poiName";
    public static final String JDPin = "JDPin";

}
