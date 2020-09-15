package org.base.data.source;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalDataSource {
    /*保存用户名*/
    void saveUserName(String userName);

    /*保存用户密码*/
    void savePassword(String password);

    /*获取用户名*/
    String getUserName();

    /*获取用户密码*/
    String getPassword();

    /*设置手机号*/
    void setPhone(String phone);

    /*设置当前地址*/
    void setCurAddress(String address);

    /*设置当前经度*/
    void setCurLon(String lon);

    /*设置当前纬度*/
    void setCurLat(String lat);

    /*获取手机号*/
    String getPhone();

    /*获取定位地址*/
    String getAddress();

    /*获取当前定位地址*/
    String getCurAddress();

    /*获取定位精度*/
    String getLon();

    /*获取定位纬度*/
    String getLat();

    /*获取当前经度*/
    String getCurLon();

    /*获取当前纬度*/
    String getCurLat();

    /*设置引导*/
    void setGuild(String guild);

    /*获取引导状态*/
    String getGuild();

    /*设置京东pin*/
    void setPin(String pin);

    /*获取pin*/
    String getPin();

    /*获取城市地址*/
    String getCity();

}
