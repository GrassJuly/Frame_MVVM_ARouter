package com.runjing.home.http

import android.content.Context
import com.runjing.home.bean.response.home.DistrictBean
import org.base.base.BCallBack
import org.base.base.BaseRequest

/**
 * @Created: qianxs  on 2020.08.15 19:37.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 19:37.
 * @Remark:
 */
interface HttpDataSource {
    /*首页-获取开通城市接口*/
    fun getDistrict(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?)

//    /*首页-获取附近门店列表*/
//    fun getStore(request: BaseRequest)
//
//    /*首页-获取banner*/
//    fun getBanner(request: BaseRequest)

//    /*首页-获取商品列表*/
//    fun getGood(request: BaseRequest)
//    fun getStoreDetail(request: BaseRequest)
//    fun getStoreGood(request: BaseRequest)
//    fun searchHistory(request: BaseRequest)
//    fun goodDetail(request: BaseRequest)

}