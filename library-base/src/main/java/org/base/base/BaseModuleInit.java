package org.base.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.socks.library.KLog;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;

import org.base.BuildConfig;

/**
 * Created by goldze on 2018/6/21 0021.
 * 基础库自身初始化操作
 */

public class BaseModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        //缓存
        MMKV.initialize(application);
        //线上检测
        CrashReport.initCrashReport(application, "92a7c20823", true);
        //开启打印日志
        KLog.init(BuildConfig.DEBUG, "qxs :::::  ");
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
