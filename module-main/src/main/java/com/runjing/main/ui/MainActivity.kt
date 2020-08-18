package com.runjing.main.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.runjing.main.BR
import com.runjing.main.R
import com.runjing.main.databinding.ActivityMainBinding
import org.base.router.RouterActivityPath
import org.base.router.RouterFragmentPath
import org.base.widget.tabview.TabView
import org.base.widget.tabview.TabViewChild
import org.frame.base.BaseActivity
import org.frame.utils.StatusBarUtil
import java.util.*

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), TabView.OnTabChildClickListener {

    var mFragments: MutableList<Fragment> = arrayListOf();
    private var tabViewChildList: MutableList<TabViewChild>? = null


    override fun initContentView(savedInstanceState: Bundle?): Int {
        StatusBarUtil.setColor(this, resources.getColor(R.color.color_F80000))
        actionBar?.hide()
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        var homeFragment = ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation() as Fragment
        var sortFragment = ARouter.getInstance().build(RouterFragmentPath.Sort.PAGER_SORT).navigation() as Fragment
        var orderFragment = ARouter.getInstance().build(RouterFragmentPath.Order.PAGER_ORDER).navigation() as Fragment
        var mineFragment = ARouter.getInstance().build(RouterFragmentPath.User.PAGER_MINE).navigation() as Fragment
        mFragments.add(homeFragment)
        mFragments.add(sortFragment)
        mFragments.add(orderFragment)
        mFragments.add(mineFragment)
        tabViewChildList = ArrayList<TabViewChild>()
        val tabViewChild01 = TabViewChild(R.mipmap.tab_home_main, R.mipmap.tab_home_main1,
                getString(R.string.main_home), homeFragment)
        val tabViewChild02 = TabViewChild(R.mipmap.tab_home_menu, R.mipmap.tab_home_menu1,
                getString(R.string.main_sort), sortFragment)
        val tabViewChild03 = TabViewChild(R.mipmap.tab_home_order, R.mipmap.tab_home_order1,
                getString(R.string.main_order), orderFragment)
        val tabViewChild04 = TabViewChild(R.mipmap.tab_home_mine, R.mipmap.tab_home_mine1,
                getString(R.string.main_mine), mineFragment)
        tabViewChildList?.add(tabViewChild01)
        tabViewChildList?.add(tabViewChild02)
        tabViewChildList?.add(tabViewChild03)
        tabViewChildList?.add(tabViewChild04)
        binding.actTbMenu.setTabViewDefaultPosition(0)
        binding.actTbMenu.setTabViewChild(tabViewChildList, supportFragmentManager)
        binding.actTbMenu.setOnTabChildClickListener(this)
    }

    override fun onTabChildClick(fragment: Fragment?, position: Int) {

    }

    override fun onTabChildClick(fragment: Fragment?, position: Int, imageView: ImageView?, textView: TextView?) {
        when (position) {
            0 -> StatusBarUtil.setColor(this, resources.getColor(R.color.color_F80000))
            1 -> {
            }
            2 -> {
                StatusBarUtil.setColor(this, resources.getColor(R.color.color_ffffff))
                StatusBarUtil.setDarkMode(this)
            }
            3 -> {
            }
        }
    }
}



