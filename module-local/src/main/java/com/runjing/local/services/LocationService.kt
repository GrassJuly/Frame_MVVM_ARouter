package com.runjing.local.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.runjing.local.utils.LocalUtil
import org.frame.utils.ToastUtils


/**
 * @Created: qianxs  on 2020.08.19 17:51.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.19 17:51.
 * @Remark:
 */
class LocationService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        LocalUtil.initLocation(applicationContext)
        LocalUtil.startLocation()
    }
}