package com.runjing.home.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.home.BR
import com.runjing.home.R
import com.runjing.home.base.HomeVMlFactory
import com.runjing.home.databinding.FragmentHomeBinding
import org.base.router.RouterFragmentPath
import org.frame.base.BaseFragment

/**
 * @Created: qianxs  on 2020.08.13 19:45.
 * @Describe：首页
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.13 19:45.
 * @Remark:
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
        viewModel.getData()
    }

    override fun initViewModel(): HomeViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法

        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: HomeVMlFactory = HomeVMlFactory.getInstance(activity?.application)
        return ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
    }
}
