package com.runjing.order;

import android.app.Application;

import com.socks.library.KLog;

import org.base.base.IModuleInit;


/**
 * Created by goldze on 2018/6/21 0021.
 */

public class OrderModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("主业务模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("主业务模块初始化 -- onInitLow");
        return false;
    }
}
