package com.runjing.home.http

import android.content.Context
import android.support.v4.app.Fragment
import android.util.Log
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.bean.response.home.DistrictBean
import com.runjing.home.http.service.HomeApiService
import com.socks.library.KLog
import org.base.base.BCallBack
import org.base.base.BaseRequest
import org.base.data.source.http.service.ApiService
import org.frame.http.net.*
import rx.Subscriber

/**
 * @Created: qianxs  on 2020.08.15 19:39.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 19:39.
 * @Remark:
 */
class HttpDataSourceImpl private constructor(homeApiService: HomeApiService?) : HttpDataSource {
    private var apiService: HomeApiService? = homeApiService

    companion object {
        @Volatile
        var instance: HttpDataSourceImpl? = null

        fun getInstance(homeApiService: HomeApiService?): HttpDataSourceImpl {
            if (instance == null) {
                synchronized(HttpDataSourceImpl::class) {
                    if (instance == null) {
                        instance = HttpDataSourceImpl(homeApiService)
                    }
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }

    //    override fun getDistrict(request: BaseRequest): Observable<DistrictBean?>? {
//        return apiService?.getDistrict(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun getStore(request: BaseRequest): Observable<HomeStoreBean?>? {
//        return apiService?.getStore(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun getBanner(request: BaseRequest) {
//        return apiService?.getBanner(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun getGood(request: BaseRequest): Observable<GoodBean?>? {
//        return apiService?.getGood(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun getStoreDetail(request: BaseRequest): Observable<DetailStroeBean?>? {
//        return apiService?.getStoreDetail(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun getStoreGood(request: BaseRequest): Observable<GoodBean?>? {
//        return apiService?.getStoreGood(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun searchHistory(request: BaseRequest): Observable<SearchHotBean?>? {
//        return apiService?.searchHistory(ApiService.BRequestBody.getB().createBody(request))
//    }
//
//    override fun goodDetail(request: BaseRequest): Observable<GoodsDetailBean?>? {
//        return apiService?.goodDetail(ApiService.BRequestBody.getB().createBody(request))
//    }

    override fun getDistrict(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?) {
        RetrofitClient.getInstance(context, ApiService.BaseUrl).execute(
                RetrofitClient.getInstance(context, ApiService.BaseUrl)
                        .create(HomeApiService::class.java)
                        .getDistrict(ApiService.BRequestBody.getB().createBody(request)),
                object : BaseSubscriber<DistrictBean?>(context) {
                    override fun onNext(t: DistrictBean?) {
                        callBack?.onResponse(t)
                    }

                    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                        callBack?.onError(e)
                    }

                    override fun onCompleted() {
                        super.onCompleted()
                        callBack?.onCompleted()
                    }
                })
    }

    fun getDistrict1(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?) {
        RetrofitClient.getInstance(context, ApiService.BaseUrl).execute(
                RetrofitClient.getInstance(context, ApiService.BaseUrl)
                        .create(HomeApiService::class.java)
                        .getDistrict(ApiService.BRequestBody.getB().createBody(request)),
                object : BaseSubscriber<DistrictBean?>(context) {
                    override fun onNext(t: DistrictBean?) {
                        callBack?.onResponse(t)
                    }

                    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                        callBack?.onError(e)
                    }
                })
    }

}