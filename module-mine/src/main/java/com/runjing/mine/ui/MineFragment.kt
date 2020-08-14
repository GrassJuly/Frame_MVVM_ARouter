package com.runjing.mine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.mine.BR
import com.runjing.mine.R
import com.runjing.mine.databinding.FragmentMineBinding
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
@Route(path = RouterFragmentPath.User.PAGER_MINE)
class MineFragment : BaseFragment<FragmentMineBinding, MineViewModel>() {
    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_mine
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }
}