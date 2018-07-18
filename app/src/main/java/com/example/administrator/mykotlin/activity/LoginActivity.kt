package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.SharedpresferenesUtils
import com.example.administrator.mykotlin.extend.myToast
import com.example.administrator.mykotlin.iview.LoginView
import com.example.administrator.mykotlin.persenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import top.jowanxu.wanandroidclient.bean.LoginResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
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
        de_login_sign.setOnClickListener(onClickListener)
        de_login_register.setOnClickListener(onClickListener)
    }

    var onClickListener = View.OnClickListener { View ->
        when (View.id) {
            R.id.de_login_sign -> {
                var name = de_login_phone.text.toString()
                var pass = de_login_password.text.toString()
                if (de_login_sign.text == "注册") {
                    basePreasenter?.regist(name, pass)
                } else {
                    basePreasenter?.login(name, pass)
                }
//                myToast("点击")
            }
            R.id.de_login_register -> {
                de_login_sign.text = "注册"
            }
        }
    }

    //登陆成功后的回调
    override fun loginSuccess(result: LoginResponse) {
//        myToast("成功")
        /*  //保存用户名和密码
          @Suppress("UNUSED_VALUE")
          var username:String by com.example.administrator.mykotlin.base.Preference("username", de_login_phone.text.toString())
          @Suppress("UNUSED_VALUE")
          var pass:String by com.example.administrator.mykotlin.base.Preference("pass",de_login_password.text.toString())
          @Suppress("UNUSED_VALUE")
          com.example.administrator.mykotlin.base.Preference("isSign",true)*/
//        SharedpresferenesUtils.shared.edit?.putBoolean("sign",true)
        if (result?.data != null) {
            SharedpresferenesUtils.shared.get(this).putBoolean("sign", true)
            SharedpresferenesUtils.shared.get(this).putString("name", de_login_phone.text.toString().trim())
            SharedpresferenesUtils.shared.get(this).putString("pass", de_login_password.text.toString().trim())
            //跳转界面
            startActivity(Intent(this@LoginActivity, ContentActivity::class.java))
            finish()
        } else {
            myToast(result?.errorMsg!!)
        }

    }

    //登陆失败后的回调
    override fun loginFaile(meass: String?) {
        myToast("失败")
    }

    //注册成功的回调
    override fun registSuccess(result: LoginResponse) {
        myToast("注册成功")
        de_login_sign.text = "登录"
    }

    //注册失败的回调
    override fun registFaile(meass: String?) {
        myToast("失败")
    }
}
