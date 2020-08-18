package com.runjing;

import android.content.Context;

import org.base.config.ModuleLifecycleConfig;
import org.frame.base.BaseApplication;

import androidx.multidex.MultiDex;

/**
 * @Created: qianxs  on 2020.07.07 02:27.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.07 02:27.
 * @Remark:
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}