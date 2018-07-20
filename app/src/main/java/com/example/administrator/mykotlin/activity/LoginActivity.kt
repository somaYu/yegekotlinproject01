package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.extend.myToast
import com.example.administrator.mykotlin.iview.ILoginView
import com.example.administrator.mykotlin.persenter.LoginPresenter
import com.example.administrator.mykotlin.util.MySpUtil
import kotlinx.android.synthetic.main.activity_login.*
import top.jowanxu.wanandroidclient.bean.LoginResponseBean

/**
 * Created by Administrator on 2018\4\11 0011.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), ILoginView {
    override fun getMyViewId(): Int = R.layout.activity_login

    override fun initMyPresenter() {
        basePreasenter = LoginPresenter(this)
    }

    override fun initMyData() {
        //实现动画
        var handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                var anim = AnimationUtils.loadAnimation(this@LoginActivity, R.anim.translate_anim)
                de_img_backgroud.startAnimation(anim)
            }
        }, 500)
        de_login_login.setOnClickListener(onClickListener)
        de_login_register.setOnClickListener(onClickListener)
    }

    var onClickListener = View.OnClickListener { View ->
        when (View.id) {
            R.id.de_login_login -> {

                var name = de_login_phone.text.toString()
                var password = de_login_password.text.toString()

                if (de_login_login.text == "注册") {
                    basePreasenter?.regist(name, password)
                } else {
                    basePreasenter?.login(name, password)
                }
//                myToast("点击")
            }

            R.id.de_login_register -> {
                de_login_login.text = "注册"
            }
        }
    }

    //注册成功的回调
    override fun myRegistSuccess(response: LoginResponseBean) {
        myToast("注册成功")
        de_login_login.text = "登录"
    }

    //注册失败的回调
    override fun myRegistFail(meass: String?) {
        myToast("失败")
    }

    //登陆成功后的回调
    override fun myLoginSuccess(response: LoginResponseBean) {
//        myToast("成功")
        /*  //保存用户名和密码
          @Suppress("UNUSED_VALUE")
          var username:String by com.example.administrator.mykotlin.util.MyPreference("username", de_login_phone.text.toString())
          @Suppress("UNUSED_VALUE")
          var pass:String by com.example.administrator.mykotlin.util.MyPreference("pass",de_login_password.text.toString())
          @Suppress("UNUSED_VALUE")
          com.example.administrator.mykotlin.util.MyPreference("isSign",true)*/
//        MySpUtil.instance.edit?.putBoolean("sign",true)
        if (response?.dataBean != null) {
            MySpUtil.instance.getInstance(this).putBoolean("sign", true)
            MySpUtil.instance.getInstance(this).putString("name", de_login_phone.text.toString().trim())
            MySpUtil.instance.getInstance(this).putString("pass", de_login_password.text.toString().trim())
            //跳转界面
            startActivity(Intent(this@LoginActivity, ContentActivity::class.java))
            finish()
        } else {
            myToast(response?.errorMsg!!)
        }

    }

    //登陆失败后的回调
    override fun myLoginFail(s: String?) {
        myToast("失败")
    }

}
