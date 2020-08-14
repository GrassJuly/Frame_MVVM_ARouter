package com.runjing.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.home.BR
import com.runjing.home.R
import com.runjing.home.databinding.FragmentHomeBinding
import org.base.router.RouterFragmentPath
import org.frame.base.BaseFragment

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}
