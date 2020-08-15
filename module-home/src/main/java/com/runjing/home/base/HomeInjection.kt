package com.runjing.home.base

import android.app.Application
import com.runjing.home.http.HttpDataSource
import com.runjing.home.http.HttpDataSourceImpl
import com.runjing.home.http.service.HomeApiService
import org.base.data.source.LocalDataSource
import org.base.data.source.local.LocalDataSourceImpl
import org.frame.http.net.RetrofitClient

/**
 * @Created: qianxs  on 2020.08.15 14:31.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 14:31.
 * @Remark:
 */
class HomeInjection private constructor(application: Application?) {
    private var application: Application? = application

    companion object {
        @Volatile
        var instance: HomeInjection? = null

        fun getInstance(application: Application?): HomeInjection {
            if (instance == null) {
                synchronized(HttpDataSourceImpl::class) {
                    if (instance == null) {
                        instance = HomeInjection(application)
                    }
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }

    fun provideRepository(): HomeRepository? {
        //网络API服务
        val apiService: HomeApiService = RetrofitClient.getInstance(application).create(HomeApiService::class.java)
        //网络数据源
        val httpDataSource: HttpDataSource = HttpDataSourceImpl.getInstance(apiService)
        //本地数据源
        val localDataSource: LocalDataSource = LocalDataSourceImpl.getInstance()
        //两条分支组成一个数据仓库
        return HomeRepository.getInstance(httpDataSource, localDataSource)
    }
}