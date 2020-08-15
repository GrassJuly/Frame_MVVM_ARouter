package com.runjing.home.base

import android.content.Context
import com.runjing.home.bean.response.good.GoodsDetailBean
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.bean.response.home.DistrictBean
import com.runjing.home.bean.response.home.GoodBean
import com.runjing.home.bean.response.home.HomeStoreBean
import com.runjing.home.bean.response.search.SearchHotBean
import com.runjing.home.bean.response.store.DetailStroeBean
import com.runjing.home.http.HttpDataSource
import okhttp3.RequestBody
import org.base.base.BCallBack
import org.base.base.BaseRequest
import org.base.data.source.LocalDataSource
import org.frame.base.BaseModel
import rx.Observable

/**
 * @Created: qianxs  on 2020.08.15 13:14.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 13:14.
 * @Remark:
 */
class HomeRepository private constructor(mHttpDataSource: HttpDataSource?, mLocalDataSource: LocalDataSource?): BaseModel(), HttpDataSource, LocalDataSource {

    private var mHttpDataSource: HttpDataSource? = mHttpDataSource

    private var mLocalDataSource: LocalDataSource? = mLocalDataSource

    companion object {
        @Volatile
        var instance: HomeRepository? = null

        fun getInstance(httpDataSource: HttpDataSource?, localDataSource: LocalDataSource?): HomeRepository {
            if (instance == null) {
                synchronized(HomeRepository::class) {
                    if (instance == null) {
                        instance = HomeRepository(httpDataSource, localDataSource)
                    }
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }



    override fun saveUserName(userName: String?) {
        mLocalDataSource?.saveUserName(userName)
    }

    override fun savePassword(password: String?) {
        mLocalDataSource?.savePassword(password)
    }

    override fun getUserName(): String {
        return mLocalDataSource?.userName!!
    }

    override fun getPassword(): String {
        return mLocalDataSource?.password!!
    }

    override fun getDistrict(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?) {
        mHttpDataSource?.getDistrict(context, request, callBack)
    }
}









