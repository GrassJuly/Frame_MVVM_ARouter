package com.runjing.local.services

import android.Manifest.permission_group.LOCATION
import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.alibaba.android.arouter.facade.annotation.Route
import com.socks.library.KLog
import org.base.router.RouterServicePath
import org.base.services.RouteService

/**
 * @Created: qianxs  on 2020.08.19 18:18.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.19 18:18.
 * @Remark:
 */
@Route(path = RouterServicePath.Local.LOCATION)
class LocationRouteService: RouteService {

    override fun init(context: Context?) {
        KLog.i(context)
    }

    override fun <T : Any?> set(vararg t: T) {
       startAlarm(t[0] as Application)
    }

    fun startAlarm(application: Application) {
        //首先获得系统服务
        val am = application.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //设置闹钟的意图，我这里是去调用一个服务，该服务功能就是获取位置并且上传
        val intent = Intent(application, LocationService::class.java)
        val pendSender = PendingIntent.getService(application, 0, intent, 0)
        am.cancel(pendSender)
        //AlarmManager.RTC_WAKEUP ;这个参数表示系统会唤醒进程；设置的间隔时间是1分钟
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 1000.toLong(), pendSender)
    }
}