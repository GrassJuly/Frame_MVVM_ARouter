package com.runjing.local.utils;

import android.content.Context;
import android.text.TextUtils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.socks.library.KLog;

import org.base.config.Appconfig;
import org.base.utils.MMKVUtil;

/**
 * @Created: qianxs  on 2020.08.17 23:49.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.08.17 23:49.
 * @Remark:
 */

public class LocalUtil implements AMapLocationListener {
    public static String lon;//经度
    public static String lat;//纬度
    public static String city;//城市
    public static String currentLon;//当前经度
    public static String currentLat;//当前纬度
    public static String currentCity;//挡墙城市
    public static String address;//地址
    public static String poiName;
    private static final String TAG = "GaodeMapUtils";
    private static LocalUtil instance;
    private AMapLocationClient mLocationClient;

    private LocalUtil() {
        address = "正在定位中...";
    }

    public static LocalUtil getInstance() {
        if (instance == null) {
            synchronized (LocalUtil.class) {
                if (instance == null)
                    instance = new LocalUtil();
            }
        }
        return instance;
    }

    public void initMap(Context mContext) {
        mLocationClient = new AMapLocationClient(mContext);
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //获取一次定位结果：
        mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        KLog.i(location);
        if (location != null) {
            StringBuffer sb = new StringBuffer();
            if (location.getErrorCode() == 0) {
                if (onLocationListener != null) {
                    onLocationListener.onLocation(location);
                }
                sb.append("定位成功" + "\n");
                sb.append("定位类型: " + location.getLocationType() + "\n");
                sb.append("经    度    : " + location.getLongitude() + "\n");
                lon = location.getLongitude() + "";
                sb.append("纬    度    : " + location.getLatitude() + "\n");
                lat = location.getLatitude() + "";
                sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
                sb.append("提供者    : " + location.getProvider() + "\n");
                sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
                sb.append("角    度    : " + location.getBearing() + "\n");
                // 获取当前提供定位服务的卫星个数
                sb.append("星    数    : " + location.getSatellites() + "\n");
                sb.append("国    家    : " + location.getCountry() + "\n");
                sb.append("省            : " + location.getProvince() + "\n");
                sb.append("市            : " + location.getCity() + "\n");
                city = location.getCity();
                sb.append("城市编码 : " + location.getCityCode() + "\n");
                sb.append("区            : " + location.getDistrict() + "\n");
                sb.append("区域 码   : " + location.getAdCode() + "\n");
                sb.append("地    址    : " + location.getAddress() + "\n");
                address = location.getAddress();
                sb.append("兴趣点    : " + location.getPoiName() + "\n");
                poiName = location.getPoiName();
                KLog.i(location.getAddress());
                System.out.println("address ======" + location.getAddress());
                //定位完成的时间
                if (MMKVUtil.getInstance().decodeDouble(Appconfig.lat) != location.getLatitude()) {
                    MMKVUtil.getInstance().encode(Appconfig.lat, location.getLatitude());
                }
                if (MMKVUtil.getInstance().decodeDouble(Appconfig.lon) != location.getLongitude()) {
                    MMKVUtil.getInstance().encode(Appconfig.lon, location.getLongitude());
                }

                if (!TextUtils.equals(MMKVUtil.getInstance().decodeString(Appconfig.address), location.getCity())) {
                    MMKVUtil.getInstance().encode(Appconfig.address, location.getAddress());
                }
                if (!TextUtils.equals(MMKVUtil.getInstance().decodeString(Appconfig.city), location.getCity())) {
                    MMKVUtil.getInstance().encode(Appconfig.city, location.getCity());
                }
            }else {
                address = "定位失败，无法获取地址";
                sb.append("定位失败" + "\n");
                sb.append("错误码:" + location.getErrorCode() + "\n");
                sb.append("错误信息:" + location.getErrorInfo() + "\n");
                sb.append("错误描述:" + location.getLocationDetail() + "\n");
            }
            sb.append("***定位质量报告***").append("\n");
            sb.append("* WIFI开关：").append(location.getLocationQualityReport().isWifiAble() ? "开启" : "关闭").append("\n");
            sb.append("* GPS状态：").append(getGPSStatusString(location.getLocationQualityReport().getGPSStatus())).append("\n");
            sb.append("* GPS星数：").append(location.getLocationQualityReport().getGPSSatellites()).append("\n");
            sb.append("* 网络类型：" + location.getLocationQualityReport().getNetworkType()).append("\n");
            sb.append("* 网络耗时：" + location.getLocationQualityReport().getNetUseTime()).append("\n");
            sb.append("****************").append("\n");
        }
    }

    /**
     * 获取GPS状态的字符串
     *
     * @param statusCode GPS状态码
     * @return
     */
    private static String getGPSStatusString(int statusCode) {
        String str = "";
        switch (statusCode) {
            case AMapLocationQualityReport.GPS_STATUS_OK:
                str = "GPS状态正常";
                break;
            case AMapLocationQualityReport.GPS_STATUS_NOGPSPROVIDER:
                str = "手机中没有GPS Provider，无法进行GPS定位";
                address = "手机中没有GPS Provider，无法进行GPS定位";
                break;
            case AMapLocationQualityReport.GPS_STATUS_OFF:
                str = "GPS关闭，建议开启GPS，提高定位质量";
                address =("未授权定位服务");
                break;
            case AMapLocationQualityReport.GPS_STATUS_MODE_SAVING:
                str = "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量";
                address = ("选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量");
                break;
            case AMapLocationQualityReport.GPS_STATUS_NOGPSPERMISSION:
                str = "没有GPS定位权限，建议开启gps定位权限";
                address = ("没有GPS定位权限，建议开启gps定位权限");
                break;
        }
        return str;
    }

    private OnLocationListener onLocationListener;

    public void setOnLocationListener(OnLocationListener onLocationListener) {
        this.onLocationListener = onLocationListener;
    }

    public interface OnLocationListener {

        void onLocation(AMapLocation location);
    }

    public void stopLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
    }

}
