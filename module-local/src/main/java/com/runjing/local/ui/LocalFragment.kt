package com.runjing.local.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.local.BR
import com.runjing.local.R
import com.runjing.local.databinding.FragmentLocalBinding
import org.base.router.RouterFragmentPath
import org.frame.base.BaseFragment

@Route(path = RouterFragmentPath.Local.PAGER_LOCAL)
class LocalFragment : BaseFragment<FragmentLocalBinding, LocalViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_local
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}
