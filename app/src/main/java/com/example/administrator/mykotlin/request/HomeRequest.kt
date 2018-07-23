package com.example.administrator.mykotlin.request

import com.example.administrator.mykotlin.bean.HomeListResponseBean
import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.presenter.HomePresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:48
 */

class HomeRequest {

    var homeList: Deferred<HomeListResponseBean>? = null

    fun getHome(p: HomePresenter, page: Int) {

        async(UI) {

            homeList = MyRetrofitHelper.instance.interR.getHomeList(page)
            val result = homeList?.await()

            result ?: let {

                p.loginFail(MyConstant.RESULT_NULL)

                return@async

            }

            p.loginSuccess(result)

        }

    }


}