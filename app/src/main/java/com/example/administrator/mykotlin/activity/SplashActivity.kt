package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.os.Handler
import android.os.Message
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.util.MySpUtil

/**
 * Created by Administrator on 2018\4\13 0013.
 */

class SplashActivity : BaseActivity<BasePresenter>() {

    // 这是特么什么语法
    // 匿名类就是这个写法
    // 没有new直接类名
    var handler = object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            val instance = MySpUtil.instance.getInstance(this@SplashActivity)

            val b = instance.getBoolean("sign", false)

            if (b) {
                startActivity(Intent(this@SplashActivity, ContentActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
            finish()

        }

    }

    override fun getMyViewId(): Int {

        return R.layout.activity_splash
    }

    override fun initMyPresenter() {
    }

    override fun initMyData() {

        handler.postDelayed(Runnable {
            kotlin.run {
                handler.sendEmptyMessage(0)
            }
        }
                , 3000)

    }


}