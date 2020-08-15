package com.runjing.home.bean.request;

import org.base.base.BaseRequest;

/**
 * 升级请求
 * Created by zm on 2016/6/28.
 */
public class UpgradeRequest extends BaseRequest {

    private String appCode;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @Override
    public String toString() {
        return "UpgradeRequest{" +
                "appCode='" + appCode + '\'' +
                '}';
    }
}
