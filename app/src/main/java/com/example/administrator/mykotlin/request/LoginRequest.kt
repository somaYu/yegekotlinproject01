package com.example.administrator.mykotlin.request

import com.example.administrator.mykotlin.bean.LoginResponseBean
import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.presenter.LoginPresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 15:08
 */

class LoginRequest() {

    // 这是个啥？
    // 接口回来的居然是个async?
    var registAsync: Deferred<LoginResponseBean>? = null

    var loginAsync: Deferred<LoginResponseBean>? = null

    fun regist(p: LoginPresenter, name: String, password: String) {

        async(UI) {

            val interR = MyRetrofitHelper.instance.interR
            registAsync = interR.regist(name, password, password)
            val result = registAsync!!.await()

            // 这个也算是返回的非空判断？
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

            val interR = MyRetrofitHelper.instance.interR
            loginAsync = interR.login(username, password)
//            val result = loginAsync!!.await()
            val result = loginAsync?.await()

            result ?: let {
                p.loginFail(MyConstant.RESULT_NULL)
                return@async
            }

            p.loginSuccess(result)

        }

    }

}

