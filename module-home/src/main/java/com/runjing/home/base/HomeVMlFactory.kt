package com.runjing.home.base

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
import android.support.annotation.VisibleForTesting
import com.runjing.home.http.HttpDataSourceImpl
import com.runjing.home.ui.HomeViewModel

/**
 * @Created: qianxs  on 2020.08.15 14:28.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 14:28.
 * @Remark:
 */
class HomeVMlFactory private constructor(application: Application, repository: HomeRepository?): NewInstanceFactory() {

    @SuppressLint("StaticFieldLeak")
    private var mApplication: Application = application
    private var mRepository: HomeRepository? = repository

    companion object {
        @Volatile
        var instance: HomeVMlFactory? = null

        fun getInstance(application: Application?): HomeVMlFactory {
            if (instance == null) {
                synchronized(HomeVMlFactory::class) {
                    if (instance == null) {
                        instance = HomeVMlFactory(application!!, HomeInjection.getInstance(application).provideRepository())
                    }
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(mApplication, mRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}