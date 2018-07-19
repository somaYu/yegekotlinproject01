package com.example.administrator.mykotlin.base

import android.app.Application
import com.example.administrator.mykotlin.util.MyPreference

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        //初始化全局变量  保存数据
        MyPreference.setMyContext(this)
//        MySpUtil.instance.getInstance(this)
    }
}