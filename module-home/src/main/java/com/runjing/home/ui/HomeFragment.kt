package com.runjing.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.home.BR
import com.runjing.home.R
import com.runjing.home.base.HomeVMlFactory
import com.runjing.home.bean.response.home.BannerBean
import com.runjing.home.databinding.FragmentHomeBinding
import com.runjing.home.widget.RJRefreshFooter
import com.runjing.home.widget.RJRefreshHeader
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.layout_banner.view.*
import kotlinx.android.synthetic.main.layout_home.view.*
import org.base.router.RouterFragmentPath
import org.frame.base.BaseFragment
import org.frame.utils.StatusBarUtil

/**
 * @Created: qianxs  on 2020.08.13 19:45.
 * @Describe：首页
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.13 19:45.
 * @Remark:这个页面还不是纯粹的mvvm模式,采用的是mvvm + mvc， 先熟悉页面逻辑后面页面重新采用mvvm模式来写
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    var adapter: HomeAdapter? = null

    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        StatusBarUtil.setColor(activity!!, resources.getColor(R.color.color_F80000))
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): HomeViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: HomeVMlFactory = HomeVMlFactory.getInstance(activity?.application)
        return ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
    }

    override fun initData() {
        super.initData()
        binding.fragSrlContent.setRefreshHeader(RJRefreshHeader(activity!!)
                .setNormalColor(getResources().getColor(R.color.color_99000000))
                .setAnimatingColor(getResources().getColor(R.color.color_99000000))
                .setSpinnerStyle(SpinnerStyle.Scale))
        binding.fragSrlContent.setRefreshFooter(RJRefreshFooter(LayoutInflater.from(activity).inflate(R.layout.layout_recycler_footer, null)))
        viewModel.getA(activity).getData()
    }


    override fun initViewObservable() {
        super.initViewObservable()
        viewModel.uc.refresh.observe(this, Observer {
            binding.fragSrlContent.finishRefresh()
        })
        viewModel.uc.loadmore.observe(this, Observer {
            binding.fragSrlContent.finishLoadMore()
        })
//        viewModel.uc.chagePage.observe(this, Observer {
//            if (TYPE_ITEM_GOOD == it) {
//                binding.frgLlHome.lay_ll_content.lay_store_status.visibility = View.GONE
//                binding.fragLlSearch.visibility = View.VISIBLE
//                binding.frgLlHome.lay_ll_content.lay_banner.visibility = View.VISIBLE
//                setMarginLL(binding.frgLlHome, 0)
//                setMarginRecy(binding.frgLlHome.lay_rv_content, 0)
//                viewModel.uc.initBanner.observe(this, Observer {
//                    homeBanner(binding.frgLlHome.lay_banner.banner, it.data)
//                })
//                val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//                binding.frgLlHome.lay_ll_content.lay_rv_content.setLayoutManager(layoutManager)
//            } else if (TYPE_ITEM_STORE == it) {
//                binding.frgLlHome.lay_ll_content.lay_store_status.visibility = View.VISIBLE
//                binding.fragLlSearch.visibility = View.GONE
//                binding.frgLlHome.lay_banner.visibility = View.GONE
//                setMarginLL(binding.frgLlHome, 0)
//                setMarginRecy(binding.frgLlHome.lay_rv_content, 28)
//            } else if (TYPE_ITEM_CITY == it) {
//                binding.frgLlHome.lay_ll_content.lay_store_status.visibility = View.VISIBLE
//                binding.fragLlSearch.visibility = View.GONE
//                binding.frgLlHome.lay_ll_content.lay_banner.visibility = View.GONE
//                setMarginLL(binding.frgLlHome, 0)
//                setMarginRecy(binding.frgLlHome.lay_rv_content, 28)
//                binding.frgLlHome.lay_ll_content.lay_rv_content.setLayoutManager(LinearLayoutManager(activity))
//                binding.frgLlHome.lay_ll_content.lay_rv_content.addItemDecoration(RecyclerViewItemDecoration(RecyclerViewItemDecoration.MODE_HORIZONTAL,
//                        resources.getColor(R.color.color_eeeeee), DensityUtils.dip2dp(activity, 1), 0, 0))
//            }
//        })
//        viewModel.uc.onData.observe(this, Observer {
//            adapter?.setData(it)
//        })

    }

//    private fun setMarginLL(ll: View?, margin: Int) {
//        val params = ll?.layoutParams as LinearLayout.LayoutParams
//        params.topMargin = DensityUtils.dip2dp(ll.context, margin)
//        ll.layoutParams = params
//    }
//
//    private fun setMarginRecy(ll: RecyclerView?, margin: Int) {
//        val params = ll?.layoutParams as LinearLayout.LayoutParams
//        params.topMargin = DensityUtils.dip2dp(ll.context, margin)
//        ll.layoutParams = params
//    }

}
