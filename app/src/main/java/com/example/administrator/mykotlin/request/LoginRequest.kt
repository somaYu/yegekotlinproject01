package com.example.administrator.mykotlin.request

import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.persenter.LoginPresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.LoginResponseBean

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class LoginRequest() {

    var loginAsync: Deferred<LoginResponseBean>? = null

    fun regist(p: LoginPresenter, name: String, password: String) {

        async(UI) {
            loginAsync = MyRetrofitHelper.instance.retrofitService.register(name, password, password)
            var result = loginAsync?.await()
            result ?: let {
                p.registFail(MyConstant.RESULT_NULL)
                return@async
            }
            p.registSuccess(result)
        }

    }

    fun login(
            onLoginListener: LoginPresenter,
            username: String, password: String
    ) {
        async(UI) {
            loginAsync = MyRetrofitHelper.instance.retrofitService.login(username, password)
            val result = loginAsync?.await()
            result ?: let {
                onLoginListener.myFail(MyConstant.RESULT_NULL)
                return@async
            }
            onLoginListener.mySuccess(result)
        }
    }

}