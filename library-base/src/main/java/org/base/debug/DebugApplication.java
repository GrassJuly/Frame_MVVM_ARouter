package org.base.debug;


import android.content.Context;

import com.socks.library.KLog;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;

import org.base.BuildConfig;
import org.base.config.ModuleLifecycleConfig;
import org.frame.base.BaseApplication;

import androidx.multidex.MultiDex;

/**
 * Created by goldze on 2018/6/25 0025.
 * debug包下的代码不参与编译，仅作为独立模块运行时初始化数据
 */

public class DebugApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
        MMKV.initialize(this);
        //线上检测
        CrashReport.initCrashReport(getApplicationContext(), "92a7c20823", true);
        KLog.init(BuildConfig.DEBUG, "wineworld :::::  ");
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
