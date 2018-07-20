package com.example.administrator.mykotlin.iview

import com.example.administrator.mykotlin.bean.LoginResponseBean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 14:27
 */

interface ILoginView {

    fun myRegistSuccess(response: LoginResponseBean)
    fun myRegistFail(s: String)

    fun myLoginSuccess(response: LoginResponseBean)
    fun myLoginFail(s: String)

}