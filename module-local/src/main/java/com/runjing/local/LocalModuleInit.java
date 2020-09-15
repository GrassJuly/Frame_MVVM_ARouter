package com.runjing.local;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.appbar.AppBarLayout;
import com.runjing.local.services.LocationService;
import com.socks.library.KLog;

import org.base.base.IModuleInit;
import org.base.router.RouterServicePath;
import org.base.services.RouteService;


/**
 * Created by goldze on 2018/6/21 0021.
 */

public class LocalModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("定位模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("定位模块初始化 -- onInitLow");
        RouteService local = (RouteService) ARouter.getInstance().build(RouterServicePath.Local.LOCATION).navigation();
        local.set(application);
        return false;
    }

}
