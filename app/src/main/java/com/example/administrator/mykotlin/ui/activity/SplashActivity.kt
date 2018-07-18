package com.example.administrator.mykotlin.ui.activity

import android.content.Intent
import android.os.Handler
import android.os.Message
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.SharedpresferenesUtils
import com.example.administrator.mykotlin.persenter.BasePresenter
import com.example.administrator.mykotlin.ui.activity.base.BaseActivity

/**
 * Created by Administrator on 2018\4\13 0013.
 */

// 孙悟空到此一游002
class SplashActivity:BaseActivity<BasePresenter>(){
    override fun getViewId(): Int= R.layout.activity_splash
    private var handler=object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
          /*  @Suppress("UNUSED_VALUE")
            var isSign:Boolean by Preference("isSign",false)*/
//            var isSign=SharedpresferenesUtils.shared.sharedPreferences?.getBoolean("sign",false)
            var isSign=SharedpresferenesUtils.shared.get(this@SplashActivity).getBoolean("sign",false)
            if(isSign!!){
                startActivity(Intent(this@SplashActivity,ContentActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
                finish()
            }
        }
    }
    override fun initPresenter() {

    }

    override fun initData() {

        handler.postDelayed(Runnable(){
            kotlin.run {
                handler.sendEmptyMessage(0)
            }
        },3500)
    }
}