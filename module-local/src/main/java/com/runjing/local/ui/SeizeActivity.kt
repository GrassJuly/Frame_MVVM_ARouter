package com.runjing.local.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.runjing.local.utils.LocalUtil
import org.base.router.RouterActivityPath

/**
 * @Created: qianxs  on 2020.08.18 16:04.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.18 16:04.
 * @Remark:
 */
@Route(path = RouterActivityPath.Local.PAGER_SEIZE)
class SeizeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalUtil.getInstance().initMap(this)
    }
}