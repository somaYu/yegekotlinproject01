package com.example.administrator.mykotlin.request

import android.util.Log
import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.persenter.LoginPresenter
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import top.jowanxu.wanandroidclient.bean.LoginResponseBean
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class LoginRequest() {

    var registAsync: Deferred<LoginResponseBean>? = null

    var loginAsync: Deferred<LoginResponseBean>? = null

    fun woqu() {
        launch(CommonPool) {
//        launch(CommonPool, CoroutineStart.DEFAULT, {

            delay(3000L, TimeUnit.MILLISECONDS)
            Log.e("yy", "hehe");
        }

    }

    fun regist(
            p: LoginPresenter
            , name: String
            , password: String) {

        async(UI) {

            registAsync = MyRetrofitHelper.instance.interR.regist(name, password, password)

            var result = registAsync?.await()

            // 大括号中的代码只有a不为空的时候才执行
            result ?: let {
                p.registFail(MyConstant.RESULT_NULL)
                return@async
            }

            p.registSuccess(result)
        }

    }

    fun login(
            p: LoginPresenter
            , username: String
            , password: String
    ) {
        async(UI) {

            loginAsync = MyRetrofitHelper.instance.interR.login(username, password)

            val result = loginAsync?.await()

            result ?: let {
                p.loginFail(MyConstant.RESULT_NULL)
                return@async
            }

            p.loginSuccess(result)

        }
    }

}