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
    fun getHome(homePresenter:HomePresenter,page:Int){
        async(UI) {
            homeList = MyRetrofitHelper.instance.retrofitService.getHomeList(page)
                var result=homeList?.await()
                result?:let{
                    homePresenter.myFail(MyConstant.RESULT_NULL)
                return@async
            }
            homePresenter.mySuccess(result)
        }
    }
}