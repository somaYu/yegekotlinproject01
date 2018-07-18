package com.example.administrator.mykotlin.net.request

import com.example.administrator.mykotlin.constant.Constant
import com.example.administrator.mykotlin.net.RetrofitHelper
import com.example.administrator.mykotlin.persenter.LoginPresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.LoginResponse

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class LoginRequest() {
    var loginAsync: Deferred<LoginResponse>? = null
    fun login(
            onLoginListener: LoginPresenter,
            username: String, password: String
    ) {
        async(UI) {
            loginAsync = RetrofitHelper.retrofitHelper.retrofitService.login(username, password)
            val result = loginAsync?.await()
            result ?: let {
                onLoginListener.faile(Constant.RESULT_NULL)
                return@async
            }
            onLoginListener.success(result)
        }
    }

    fun regist(listen: LoginPresenter, name: String, pass: String) {
        async(UI) {
            loginAsync = RetrofitHelper.retrofitHelper.retrofitService.register(name, pass, pass)
            var result = loginAsync?.await()
            result ?: let {
                listen.faileRegist(Constant.RESULT_NULL)
                return@async
            }
            listen.successRegist(result)
        }
    }

}