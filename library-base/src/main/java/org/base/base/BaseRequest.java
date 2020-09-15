package org.base.base;


import org.base.config.Appconfig;
import org.base.utils.MMKVUtil;

/**
 * @Created by xiaoyu on 2017/1/6.
 * @Describe：公共请求Bean
 * @Review by：
 * @Modify by：
 * @Version : $ v_1.0 on 2017/1/6.
 * @Remark:
 */
public class BaseRequest {
    private String phonemodel;//手机机型
    private String deviceId; //设备id
    private String sessionId;//标识码判断登录过期
    private String appVersion;//版本信息
    private String latitude;
    private String longitude;
    private String currentLat;
    private String currentLon;
//    private String platformType;

    public BaseRequest() {
//        this.latitude =  "39.9219";
        this.latitude = MMKVUtil.getInstance().decodeDouble(Appconfig.lat) + "";
//        this.longitude =  "116.44355";
        this.longitude = MMKVUtil.getInstance().decodeDouble(Appconfig.lon) + "";
        this.currentLat = MMKVUtil.getInstance().decodeDouble(Appconfig.currentlat) + "";
        this.currentLon = MMKVUtil.getInstance().decodeDouble(Appconfig.currentlon) + "";
//        platformType = "4";
    }

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCurrentLat() {
        return currentLat;
    }

    public void setCurrentLat(String currentLat) {
        this.currentLat = currentLat;
    }

    public String getCurrentLon() {
        return currentLon;
    }

    public void setCurrentLon(String currentLon) {
        this.currentLon = currentLon;
    }

//    public String getPlatformType() {
//        return platformType;
//    }

//    public void setPlatformType(String platformType) {
//        this.platformType = platformType;
//    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "phonemodel='" + phonemodel + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", currentLat='" + currentLat + '\'' +
                ", currentLon='" + currentLon + '\'' +
//                ", platformType='" + platformType + '\'' +
                '}';
    }
}
