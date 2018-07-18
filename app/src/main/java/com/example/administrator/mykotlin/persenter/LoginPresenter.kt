package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.bean.BaseResponse
import com.example.administrator.mykotlin.iview.LoginView
import com.example.administrator.mykotlin.net.request.LoginRequest
import top.jowanxu.wanandroidclient.bean.LoginResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
class LoginPresenter(var iview: LoginView) : BasePresenter() {
    fun login(name: String, pass: String) {
        var request = LoginRequest()
        request.login(this, name, pass)
    }

    fun regist(name: String, pass: String) {
        var request = LoginRequest()
        request.regist(this, name, pass)
    }

    override fun mySuccess(response: BaseResponse) {
        iview.loginSuccess(response as LoginResponse)
    }

    override fun myFail(error: String?) {
        iview.loginFaile(error)
    }

    fun successRegist(result: BaseResponse) {
        iview.registSuccess(result as LoginResponse)
    }

    fun faileRegist(meassage: String?) {
        iview.registFaile(meassage)
    }
}