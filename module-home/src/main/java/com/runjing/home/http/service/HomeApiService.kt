package com.runjing.home.http.service

import com.runjing.home.bean.response.good.GoodsDetailBean
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.bean.response.home.DistrictBean
import com.runjing.home.bean.response.home.GoodBean
import com.runjing.home.bean.response.home.HomeStoreBean
import com.runjing.home.bean.response.search.SearchHotBean
import com.runjing.home.bean.response.store.DetailStroeBean
import okhttp3.RequestBody
import org.base.data.source.http.service.ApiService
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable


/**
 * @Created: qianxs  on 2020.08.15 13:08.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 13:08.
 * @Remark:
 */
interface HomeApiService {

    /*首页-获取开通城市接口*/
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("district/getDistrict")
    fun getDistrict(@Body body: RequestBody?): Observable<DistrictBean?>?

    /*首页-获取附近门店列表*/
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("freshStore/list ")
    fun getStore(@Body body: RequestBody?): Observable<HomeStoreBean?>?

    /*首页-获取banner*/
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("banner/wxIndexGet")
    fun getBanner(@Body body: RequestBody?): Observable<BannerBean?>?

    /*首页-获取商品列表*/
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("product/wxStoreSku")
    fun getGood(@Body body: RequestBody?): Observable<GoodBean?>? /*首页-获取商品列表*/

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("freshStore/detail")
    fun getStoreDetail(@Body body: RequestBody?): Observable<DetailStroeBean?>? /*首页-获取商品列表*/

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("freshStore/getGoodsByStoreId")
    fun getStoreGood(@Body body: RequestBody?): Observable<GoodBean?>?

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("config/wxIndexGetHots")
    fun searchHistory(@Body body: RequestBody?): Observable<SearchHotBean?>?

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("freshProduct/getFreshSkuDetail")
    fun goodDetail(@Body body: RequestBody?): Observable<GoodsDetailBean?>?
}