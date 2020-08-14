package com.runjing.sort.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.sort.BR
import com.runjing.sort.R
import com.runjing.sort.databinding.FragmentSortBinding
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
@Route(path = RouterFragmentPath.Sort.PAGER_SORT)
class SortFragment : BaseFragment<FragmentSortBinding, SortViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_sort
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}