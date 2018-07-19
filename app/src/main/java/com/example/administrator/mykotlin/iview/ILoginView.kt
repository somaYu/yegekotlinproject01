package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.LoginResponseBean

/**
 * Created by Administrator on 2018\4\11 0011.
 */
interface ILoginView {

    fun myRegistSuccess(response: LoginResponseBean)
    fun myRegistFail(s: String?)

    fun myLoginSuccess(response: LoginResponseBean)
    fun myLoginFail(s: String?)

}
