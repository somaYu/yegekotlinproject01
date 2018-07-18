package com.example.administrator.mykotlin.activity

import android.os.Handler
import android.os.Message
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.BasePresenter

/**
 * Created by Administrator on 2018\4\13 0013.
 */

class SplashActivity : BaseActivity<BasePresenter>() {

    // 这是特么什么语法
    var handler = object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)


        }

    }

    override fun getMyViewId(): Int {

        return R.layout.activity_splash
    }

    override fun initMyPresenter() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initMyData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}