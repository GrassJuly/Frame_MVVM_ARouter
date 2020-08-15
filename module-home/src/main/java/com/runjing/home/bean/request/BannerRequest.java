package com.runjing.home.bean.request;


import org.base.base.BaseRequest;

/**
 * @Created: qianxs  on 2020.07.30 16:01.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.30 16:01.
 * @Remark:
 */
public class BannerRequest extends BaseRequest {
    private String platformType;
//    private String platformType = "4";

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    @Override
    public String toString() {
        return "BannerRequest{" +
                "platformType=" + platformType +
                '}';
    }
}
