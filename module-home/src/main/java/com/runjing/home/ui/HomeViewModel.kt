package com.runjing.home.ui

import android.app.Application
import com.runjing.home.base.HomeRepository
import com.runjing.home.bean.response.home.DistrictBean
import com.socks.library.KLog
import org.base.base.BCallBack
import org.base.base.BaseRequest
import org.base.data.BaseRepository
import org.frame.base.BaseViewModel
import org.frame.http.net.ExceptionHandle

/**
 * @Created: qianxs  on 2020.08.13 19:45.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.13 19:45.
 * @Remark:
 */
class HomeViewModel : BaseViewModel<HomeRepository> {
    constructor(application: Application) : super(application)
    constructor(application: Application, model: HomeRepository?) : super(application, model)

    fun getData() {
        model.getDistrict(getApplication(), BaseRequest(), object : BCallBack<DistrictBean>{
            override fun onResponse(response: DistrictBean?) {
                KLog.i(response)
            }

            override fun onError(throwable: ExceptionHandle.ResponeThrowable?) {
                KLog.i(throwable)
            }

            override fun onCompleted() {

            }
        })
    }

}