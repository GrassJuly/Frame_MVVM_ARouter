package com.runjing.home.bean.request;

import org.base.base.BaseRequest;

/**
 * @Created: qianxs  on 2020.08.04 14:55.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.08.04 14:55.
 * @Remark:
 */
public class SearchGoodRequest extends BaseRequest {
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "SearchGoodRequest{" +
                "goodsName='" + goodsName + '\'' +
                '}';
    }
}
