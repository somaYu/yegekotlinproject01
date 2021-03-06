package com.example.administrator.mykotlin.request

import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.persenter.HomePresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.HomeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class HomeRequest {

    var homeList: Deferred<HomeListResponseBean>? = null

    fun getHome(p: HomePresenter, page: Int) {
        async(UI) {

            homeList = MyRetrofitHelper.instance.interR.getHomeList(page)
            var result = homeList?.await()

            result ?: let {
                p.loginFail(MyConstant.RESULT_NULL)
                return@async
            }

            p.loginSuccess(result)
        }
    }

}