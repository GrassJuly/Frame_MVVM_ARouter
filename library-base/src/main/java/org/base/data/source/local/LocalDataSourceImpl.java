package org.base.data.source.local;

import org.base.config.Appconfig;
import org.base.data.source.LocalDataSource;
import org.base.utils.SpUtil;
import org.frame.utils.SPUtils;

/**
 * 本地数据源，可配合Room框架使用
 * Created by goldze on 2019/3/26.
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }

    @Override
    public void saveUserName(String userName) {
        SpUtil.INSTANCE.encode(Appconfig.User, userName);
    }

    @Override
    public void savePassword(String password) {
        SpUtil.INSTANCE.encode(Appconfig.PassWord, password);
    }

    @Override
    public String getUserName() {
        return SpUtil.INSTANCE.decodeString(Appconfig.User);
    }

    @Override
    public String getPassword() {
        return SpUtil.INSTANCE.decodeString(Appconfig.User);
    }

    @Override
    public void setPhone(String phone) {
        SpUtil.INSTANCE.encode(Appconfig.Phone, phone);
    }

    @Override
    public void setCurAddress(String address) {
        SpUtil.INSTANCE.encode(Appconfig.CurAddress, address);
    }

    @Override
    public void setCurLon(String lon) {
        SpUtil.INSTANCE.encode(Appconfig.currentlon, lon);
    }

    @Override
    public void setCurLat(String lat) {
        SpUtil.INSTANCE.encode(Appconfig.currentlat, lat);
    }

    @Override
    public String getPhone() {
        return SpUtil.INSTANCE.decodeString(Appconfig.Phone);
    }

    @Override
    public String getAddress() {
        return SpUtil.INSTANCE.decodeString(Appconfig.address);

    }

    @Override
    public String getCurAddress() {
        return SpUtil.INSTANCE.decodeString(Appconfig.CurAddress);
    }

    @Override
    public String getLon() {
        return SpUtil.INSTANCE.decodeString(Appconfig.lon);
    }

    @Override
    public String getLat() {
        return SpUtil.INSTANCE.decodeString(Appconfig.lat);
    }

    @Override
    public String getCurLon() {
        return SpUtil.INSTANCE.decodeString(Appconfig.currentlon);
    }

    @Override
    public String getCurLat() {
        return SpUtil.INSTANCE.decodeString(Appconfig.currentlat);
    }

    @Override
    public void setGuild(String guild) {
        SpUtil.INSTANCE.encode(Appconfig.IS_GUILD, guild);

    }

    @Override
    public String getGuild() {
        return SpUtil.INSTANCE.decodeString(Appconfig.IS_GUILD);
    }

    @Override
    public void setPin(String pin) {
        SpUtil.INSTANCE.encode(Appconfig.JDPin, pin);
    }

    @Override
    public String getPin() {
        return SpUtil.INSTANCE.decodeString(Appconfig.JDPin);
    }

    @Override
    public String getCity() {
        return SpUtil.INSTANCE.decodeString(Appconfig.city);
    }
}
