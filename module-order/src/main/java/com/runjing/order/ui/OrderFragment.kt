package com.runjing.order.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.order.BR
import com.runjing.order.R
import com.runjing.order.databinding.FragmentOrderBinding
import org.base.router.RouterFragmentPath
import org.frame.base.BaseFragment

/**
 * @Created: qianxs  on 2020.08.13 23:26.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.13 23:26.
 * @Remark:
 */
@Route(path = RouterFragmentPath.Order.PAGER_ORDER)
class OrderFragment : BaseFragment<FragmentOrderBinding, OrderViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_order
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}