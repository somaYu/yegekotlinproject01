package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.base.BaseResponseBean
import com.example.administrator.mykotlin.iview.ILoginView
import com.example.administrator.mykotlin.request.LoginRequest
import top.jowanxu.wanandroidclient.bean.LoginResponseBean

/**
 * Created by Administrator on 2018\4\11 0011.
 */
class LoginPresenter(var iview: ILoginView) : BasePresenter() {

    fun login(name: String, pass: String) {
        var request = LoginRequest()
        request.login(this, name, pass)
    }

    fun regist(name: String, pass: String) {
        var request = LoginRequest()
        request.regist(this, name, pass)
    }

    fun registSuccess(result: BaseResponseBean) {
        iview.myRegistSuccess(result as LoginResponseBean)
    }

    fun registFail(meassage: String?) {
        iview.myRegistFail(meassage)
    }

    override fun mySuccess(responseBean: BaseResponseBean) {
        iview.myLoginSuccess(responseBean as LoginResponseBean)
    }

    override fun myFail(s: String?) {
        iview.myLoginFail(s)
    }


}