package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.LoginResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
interface LoginView {
    fun loginSuccess(result:LoginResponse)
    fun loginFaile(meass:String?)
    fun registSuccess(result: LoginResponse)
    fun registFaile(meass: String?)
}