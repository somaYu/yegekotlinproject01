package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.bean.LoginResponseBean
import com.example.administrator.mykotlin.extend.myToast
import com.example.administrator.mykotlin.iview.ILoginView
import com.example.administrator.mykotlin.presenter.LoginPresenter
import com.example.administrator.mykotlin.util.MySpUtil
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 10:01
 */

class LoginActivity
    : BaseActivity<LoginPresenter>()
        , ILoginView {


    override fun getMyViewId(): Int {
        return R.layout.activity_login
    }

    override fun initMyPresenter() {
        basePresenter = LoginPresenter(this)
    }

    override fun initMyData() {

        var handler = Handler();

        handler.postDelayed(object : Runnable {

            override fun run() {

                val anim = AnimationUtils.loadAnimation(this@LoginActivity
                        , R.anim.translate_anim)

                de_img_backgroud.startAnimation(anim)

            }

        }, 500)

        de_login_login.setOnClickListener(onClickListener)
        de_login_register.setOnClickListener(onClickListener)

    }

    var onClickListener = View.OnClickListener { View ->

        when (View.id) {

            R.id.de_login_login -> {

                val name = de_login_phone.text.toString().trim()
                val password = de_login_password.text.toString().trim()

                if (de_login_login.text == "注册") {

                    basePresenter?.regist(name, password)

                } else {
                    basePresenter?.login(name, password)
                }

            }

            R.id.de_login_register -> {
                de_login_login.text = "注册"
            }

        }

    }

    override fun myRegistSuccess(response: LoginResponseBean) {
        myToast("注册成功")
        de_login_login.text = "登录"
    }

    override fun myRegistFail(s: String) {
        myToast("失败")
    }

    override fun myLoginSuccess(response: LoginResponseBean) {

        if (response.dataBean != null) {
            MySpUtil.instance.getInstance(this).putBoolean("sign", true)
            MySpUtil.instance.getInstance(this).putString("name", de_login_phone.text.toString().trim())
            MySpUtil.instance.getInstance(this).putString("pass", de_login_password.text.toString().trim())

            startActivity(Intent(this@LoginActivity, ContentActivity::class.java))
            finish()
        } else {
            myToast(response.errorMsg)
        }

    }

    override fun myLoginFail(s: String) {
        myToast("失败")
    }


}
