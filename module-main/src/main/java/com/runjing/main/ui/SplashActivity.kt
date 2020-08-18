package com.runjing.main.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import org.frame.utils.StatusBarUtil

/**
 * @Created: qianxs  on 2020.08.13 10:45.
 * @Describe：欢迎界面
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.13 10:45.
 * @Remark:
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setTransparentForWindow(this)
        Handler().postDelayed(Runnable {
            intoPage()
        }, 1000)
    }

    fun intoPage() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}