package com.example.administrator.mykotlin.presenter

import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.base.BaseResponseBean
import com.example.administrator.mykotlin.bean.LoginResponseBean
import com.example.administrator.mykotlin.iview.ILoginView
import com.example.administrator.mykotlin.request.LoginRequest

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 14:58
 */

class LoginPresenter(var iview: ILoginView) : BasePresenter() {

    fun regist(name: String, password: String) {

        val request = LoginRequest()
        request.regist(this, name, password)

    }

    fun registSuccess(responseBean: BaseResponseBean) {

        iview.myRegistSuccess(responseBean as LoginResponseBean)

    }

    fun registFail(s: String) {
        iview.myRegistFail(s)
    }

    fun login(name: String, password: String) {
        var request = LoginRequest()
        request.login(this, name, password)
    }

    override fun loginSuccess(responseBean: BaseResponseBean) {
        iview.myLoginSuccess(responseBean as LoginResponseBean)
    }

    override fun loginFail(s: String) {
        iview.myLoginFail(s)
    }

}