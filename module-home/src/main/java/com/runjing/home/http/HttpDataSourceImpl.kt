package com.runjing.home.http

import android.content.Context
import com.runjing.home.bean.request.HomeRequest
import com.runjing.home.bean.response.home.*
import com.runjing.home.http.service.HomeApiService
import org.base.base.BCallBack
import org.base.base.BaseRequest
import org.base.data.source.http.service.ApiService
import org.frame.http.net.BaseSubscriber
import org.frame.http.net.ExceptionHandle
import org.frame.http.net.NetworkUtil
import org.frame.http.net.RetrofitClient
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @Created: qianxs  on 2020.08.15 19:39.
 * @Describe：网络数据封装
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

    override fun getHome(context: Context, homeRequest: BaseRequest, callBack: BCallBack<HomeBean>?) {
        var request = BaseRequest()
        var district: Observable<DistrictBean?>? = apiService?.getDistrict(ApiService
                .BRequestBody.getB().createBody(request))?.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread());
        var store: Observable<HomeStoreBean?>? = apiService?.getStore(ApiService
                .BRequestBody.getB().createBody(request))?.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread());
        var good: Observable<GoodBean?>? = apiService?.getGood(ApiService
                .BRequestBody.getB().createBody(homeRequest))?.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread());
        var banner: Observable<BannerBean?>? = apiService?.getBanner(ApiService
                .BRequestBody.getB().createBody(request))?.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread());
        val homeObservable = Observable.zip(district, store, good, banner) { districtBean, homeStoreBean, goodBean,
                                                                             bannerBean ->
            HomeBean(districtBean, homeStoreBean, bannerBean, goodBean)
        }
        homeObservable.subscribe(object : BaseSubscriber<HomeBean?>(context) {
            override fun onNext(t: HomeBean?) {
                callBack?.onResponse(t)
            }

            override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                callBack?.onError(e)
            }

            override fun onCompleted() {
                super.onCompleted()
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    callBack?.onCompleted()
                }
            }
        })
    }

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
                        if (!NetworkUtil.isNetworkAvailable(context)) {
                            callBack?.onCompleted()
                        }
                    }
                })
    }

    override fun getStore(context: Context, request: BaseRequest, callBack: BCallBack<HomeStoreBean>?) {
        RetrofitClient.getInstance(context, ApiService.BaseUrl).execute(
                RetrofitClient.getInstance(context, ApiService.BaseUrl)
                        .create(HomeApiService::class.java)
                        .getStore(ApiService.BRequestBody.getB().createBody(request)),
                object : BaseSubscriber<HomeStoreBean?>(context) {
                    override fun onNext(t: HomeStoreBean?) {
                        callBack?.onResponse(t)
                    }

                    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                        callBack?.onError(e)
                    }

                    override fun onCompleted() {
                        super.onCompleted()
                        if (!NetworkUtil.isNetworkAvailable(context)) {
                            callBack?.onCompleted()
                        }
                    }
                })
    }

    override fun getBanner(context: Context, request: BaseRequest, callBack: BCallBack<BannerBean>?) {
        RetrofitClient.getInstance(context, ApiService.BaseUrl).execute(
                RetrofitClient.getInstance(context, ApiService.BaseUrl)
                        .create(HomeApiService::class.java)
                        .getBanner(ApiService.BRequestBody.getB().createBody(request)),
                object : BaseSubscriber<BannerBean?>(context) {
                    override fun onNext(t: BannerBean?) {
                        callBack?.onResponse(t)
                    }

                    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                        callBack?.onError(e)
                    }

                    override fun onCompleted() {
                        super.onCompleted()
                        if (!NetworkUtil.isNetworkAvailable(context)) {
                            callBack?.onCompleted()
                        }
                    }
                })
    }

    override fun getGood(context: Context, request: BaseRequest, callBack: BCallBack<GoodBean>?) {
        RetrofitClient.getInstance(context, ApiService.BaseUrl).execute(
                RetrofitClient.getInstance(context, ApiService.BaseUrl)
                        .create(HomeApiService::class.java)
                        .getGood(ApiService.BRequestBody.getB().createBody(request)),
                object : BaseSubscriber<GoodBean?>(context) {
                    override fun onNext(t: GoodBean?) {
                        callBack?.onResponse(t)
                    }

                    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
                        callBack?.onError(e)
                    }

                    override fun onCompleted() {
                        super.onCompleted()
                        if (!NetworkUtil.isNetworkAvailable(context)) {
                            callBack?.onCompleted()
                        }
                    }
                })
    }
}