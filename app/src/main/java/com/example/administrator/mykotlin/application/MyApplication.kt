package com.example.administrator.mykotlin.application

import android.app.Application
import com.example.administrator.mykotlin.util.MyPreference

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/20 16:03
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        MyPreference.setMyContext(this)

    }

}