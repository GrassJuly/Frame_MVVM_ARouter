package com.runjing.local;

import android.app.Application;

import com.socks.library.KLog;

import org.base.base.IModuleInit;


/**
 * Created by goldze on 2018/6/21 0021.
 */

public class LocalModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("首页模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("首页模块初始化 -- onInitLow");
        return false;
    }
}