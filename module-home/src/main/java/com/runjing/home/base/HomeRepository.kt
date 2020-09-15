package com.runjing.home.base

import android.content.Context
import android.text.TextUtils
import com.runjing.home.bean.response.home.*
import com.runjing.home.http.HttpDataSource
import org.base.base.BCallBack
import org.base.base.BaseRequest
import org.base.data.source.LocalDataSource
import org.frame.base.BaseModel

/**
 * @Created: qianxs  on 2020.08.15 13:14.
 * @Describe：网络数据与本地数据注入
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 13:14.
 * @Remark:
 */
class HomeRepository private constructor(mHttpDataSource: HttpDataSource?, mLocalDataSource: LocalDataSource?) : BaseModel(), HttpDataSource, LocalDataSource {

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
        mLocalDataSource!!.saveUserName(userName)
    }

    override fun savePassword(password: String?) {
        mLocalDataSource!!.savePassword(password)
    }

    override fun getUserName(): String? {
        return mLocalDataSource!!.userName
    }

    override fun getPassword(): String? {
        return mLocalDataSource!!.password
    }

    override fun setPhone(phone: String?) {
        mLocalDataSource!!.phone = phone
    }

    override fun setCurAddress(address: String?) {
        mLocalDataSource!!.curAddress = address
    }

    override fun setCurLon(lon: String?) {
        mLocalDataSource!!.curLon = lon
    }

    override fun setCurLat(lat: String?) {
        mLocalDataSource!!.curLat = lat
    }

    override fun getPhone(): String? {
        return mLocalDataSource!!.phone
    }

    override fun getAddress(): String? {
        return if (TextUtils.isEmpty(mLocalDataSource!!.address)) {
            "无法获取地址"
        } else mLocalDataSource!!.address
    }

    override fun getCurAddress(): String? {
        return mLocalDataSource!!.curAddress
    }

    override fun getLon(): String? {
        return mLocalDataSource!!.lon
    }

    override fun getLat(): String? {
        return mLocalDataSource!!.lat
    }

    override fun getCurLon(): String? {
        return mLocalDataSource!!.curLon
    }

    override fun getCurLat(): String? {
        return mLocalDataSource!!.curLat
    }

    override fun setGuild(guild: String?) {
        mLocalDataSource!!.guild = guild
    }

    override fun getGuild(): String? {
        return mLocalDataSource!!.guild
    }

    override fun setPin(pin: String?) {
        mLocalDataSource!!.pin = pin
    }

    override fun getPin(): String? {
        return mLocalDataSource!!.pin
    }

    override fun getCity(): String {
        return mLocalDataSource!!.city
    }

    override fun getHome(context: Context, request: BaseRequest, callBack: BCallBack<HomeBean>?) {
        mHttpDataSource?.getHome(context, request, callBack)
    }

    override fun getDistrict(context: Context, request: BaseRequest, callBack: BCallBack<DistrictBean>?) {
        mHttpDataSource?.getDistrict(context, request, callBack)
    }

    override fun getStore(context: Context, request: BaseRequest, callBack: BCallBack<HomeStoreBean>?) {
        mHttpDataSource?.getStore(context, request, callBack)
    }

    override fun getBanner(context: Context, request: BaseRequest, callBack: BCallBack<BannerBean>?) {
        mHttpDataSource?.getBanner(context, request, callBack)
    }

    override fun getGood(context: Context, request: BaseRequest, callBack: BCallBack<GoodBean>?) {
        mHttpDataSource?.getGood(context, request, callBack)
    }
}









