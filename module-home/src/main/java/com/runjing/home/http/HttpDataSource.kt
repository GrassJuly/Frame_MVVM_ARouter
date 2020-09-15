package com.runjing.home.http

import android.content.Context
import com.runjing.home.bean.response.home.*
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
    /*首页-获取首页数据*/
    fun getHome(context: Context, request: BaseRequest, callBack: BCallBack<HomeBean>?)
    /*首页-获取开通城市接口*/
    fun getDistrict(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?)
    /*首页-获取附近门店列表*/
    fun getStore(context: Context, request: BaseRequest, callBack: BCallBack<HomeStoreBean>?)
    /*首页-获取banner*/
    fun getBanner(context: Context, request: BaseRequest, callBack: BCallBack<BannerBean>?)
    /*首页-获取商品列表*/
    fun getGood(context: Context, request: BaseRequest, callBack: BCallBack<GoodBean>?)

}