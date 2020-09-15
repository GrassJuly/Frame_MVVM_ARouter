package com.runjing.home.ui

import android.app.Activity
import android.app.Application
import android.text.TextUtils
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentActivity
import com.runjing.home.base.HomeRepository
import com.runjing.home.bean.request.HomeRequest
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.bean.response.home.DistrictBean
import com.runjing.home.bean.response.home.HomeBean
import com.runjing.home.ui.shop.LocalFragment
import com.runjing.home.ui.shop.SearchFragment
import com.runjing.home.ui.shop.ShopListFragment
import com.socks.library.KLog
import org.base.base.BCallBack
import org.base.config.Appconfig
import org.frame.base.BaseViewModel
import org.frame.binding.command.BindingAction
import org.frame.binding.command.BindingCommand
import org.frame.bus.event.SingleLiveEvent
import org.frame.http.net.ExceptionHandle
import org.frame.utils.constant.BaseConfig
import java.util.*

/**
 * @Created: qianxs  on 2020.08.21 16:15.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.21 16:15.
 * @Remark:
 */

class HomeViewModel : BaseViewModel<HomeRepository> {
    var address: ObservableField<String>? = ObservableField()
    var activity: FragmentActivity? = null
    var uc = UIChangeObservable()
    var page = 1;
    var request = HomeRequest()
    var data = ObservableField<HomeBean>();

    class UIChangeObservable {
        var refresh = SingleLiveEvent<Objects>()
        var loadmore = SingleLiveEvent<Objects>()
    }

    constructor(application: Application, model: HomeRepository?) : super(application, model) {
        request.pageSize = Appconfig.pageSize
    }

    fun getA(activity: FragmentActivity?): HomeViewModel {
        this.activity = activity
        return this;
    }

    fun getData() {
        request.pageNo = page
        model.getHome(getApplication(), request, object : BCallBack<HomeBean> {
            override fun onResponse(response: HomeBean?) {
                setData(response)
            }

            override fun onError(throwable: ExceptionHandle.ResponeThrowable?) {
                KLog.i(throwable)
            }

            override fun onCompleted() {

            }
        })
    }

    var onRefresh = BindingCommand<Object>(BindingAction {
        page = 1;
        getData()
    })
    var onLoadMore = BindingCommand<Object>(BindingAction {
        page++
        getData()
    })

    fun setData(response: HomeBean?) {
        address?.set(model.address)
        if (isOpenCity(response?.districtBean?.data, model.city)) {
            if (1 == response?.homeStoreBean?.data?.type) {
                response.itemTpye = BaseConfig.CONFIG_ONE
            } else if (2 == response?.homeStoreBean?.data?.type) {
                response.itemTpye = BaseConfig.CONFIG_TWO
            }
        } else {
            response?.itemTpye = BaseConfig.CONFIG_THREE
        }
        if (page == 1) {
            uc.refresh.call()
        } else {
            uc.loadmore.call()
        }
        data.set(response)
    }

    /**
     * @param data
     * @param city
     */
    private fun isOpenCity(data: List<DistrictBean.DataBean>?, city: String?): Boolean {
        if (null != data && data.isNotEmpty() && !TextUtils.isEmpty(city)) {
            for (dataBean in data) {
                if (TextUtils.equals(city, dataBean.getName())) {
                    return true
                }
            }
        }
        return false
    }

    var onLocal = BindingCommand<Object>(BindingAction {
        startContainerActivity(LocalFragment::class.java.getCanonicalName())
    })

    var onShop = BindingCommand<Object>(BindingAction {
        startContainerActivity(ShopListFragment::class.java.getCanonicalName())
    })

    var onSearch = BindingCommand<Object>(BindingAction {
        startContainerActivity(SearchFragment::class.java.getCanonicalName())
    })

    var onNextStore = BindingCommand<Object>(BindingAction {
        startContainerActivity(SearchFragment::class.java.getCanonicalName())
    })

    var onQucikOrder = BindingCommand<Object>(BindingAction {
        startContainerActivity(SearchFragment::class.java.getCanonicalName())
    })
    var onCoin = BindingCommand<Object>(BindingAction {
        startContainerActivity(SearchFragment::class.java.getCanonicalName())
    })


}


















