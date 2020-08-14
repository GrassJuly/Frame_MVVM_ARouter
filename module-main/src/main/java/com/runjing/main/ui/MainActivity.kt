package com.runjing.main.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.main.BR
import com.runjing.main.R
import com.runjing.main.databinding.ActivityMainBinding
import org.base.router.RouterActivityPath
import org.frame.base.BaseActivity

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

}
