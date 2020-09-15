package com.runjing.home.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.runjing.home.BR
import com.runjing.home.R
import com.runjing.home.databinding.FragmentSearchBinding
import com.runjing.home.databinding.FragmentShopListBinding
import com.runjing.home.ui.search.SearchViewModel
import org.frame.base.BaseFragment

/**
 * @Created: qianxs  on 2020.08.21 22:37.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.21 22:37.
 * @Remark:
 */
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_search
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}