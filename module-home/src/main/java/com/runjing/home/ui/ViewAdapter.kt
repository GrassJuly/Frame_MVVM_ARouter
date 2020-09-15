package com.runjing.home.ui

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.bean.response.home.HomeBean
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import org.base.utils.DensityUtils
import org.base.utils.RecyclerViewItemDecoration
import org.base.utils.SpacesItemDecoration
import org.frame.utils.constant.BaseConfig

/**
 * @Created: qianxs  on 2020.09.14 18:28.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.09.14 18:28.
 * @Remark:
 */
class ViewAdapter {

    companion object {

        @BindingAdapter(value = ["home_owner", "home_images"], requireAll = false)
        @JvmStatic
        fun setBanner(banner: Banner<*, *>?, owner: FragmentActivity?, images: List<BannerBean.DataBean>?) {
            val adapter = BannerItemAdapter(images)
            banner?.setDelayTime(5000)
            banner?.setBannerRound(20f)
            banner?.addBannerLifecycleObserver(owner)
                    ?.setAdapter(adapter)
                    ?.setIndicator(CircleIndicator(banner.context), true)
                    ?.start()
        }

        @BindingAdapter(value = ["home_data"], requireAll = false)
        @JvmStatic
        fun setRecyclerData(recyclerView: RecyclerView?, data: HomeBean?) {
            var adapter = HomeAdapter()
            recyclerView?.adapter = adapter;
            when (data?.itemTpye) {
                BaseConfig.CONFIG_ONE -> {
                    var manger = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView?.layoutManager = manger
//                    recyclerView?.addItemDecoration(SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.context, 10), SpacesItemDecoration.STAGGEREDGRIDLAYOUT))
                }
                BaseConfig.CONFIG_TWO -> {
                    var manager = LinearLayoutManager(recyclerView?.context)
                    recyclerView?.layoutManager = manager
                    recyclerView?.addItemDecoration(SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.context, 1), SpacesItemDecoration.LINEARLAYOUT))
                }
                BaseConfig.CONFIG_THREE -> {
                    var manger = LinearLayoutManager(recyclerView?.context)
                    recyclerView?.layoutManager = manger
//                    recyclerView?.addItemDecoration(SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.context, 1), SpacesItemDecoration.LINEARLAYOUT))
                }
            }
            adapter.setData(data);
        }
    }

}