package com.example.administrator.mykotlin.net.request

import com.example.administrator.mykotlin.constant.Constant
import com.example.administrator.mykotlin.net.RetrofitHelper
import com.example.administrator.mykotlin.persenter.HomePresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.HomeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class HomeRequest {

    var homeList:Deferred<HomeListResponse>?=null
    fun getHome(homePresenter:HomePresenter,page:Int){
        async(UI) {
                homeList=RetrofitHelper.retrofitHelper.retrofitService.getHomeList(page)
                var result=homeList?.await()
                result?:let{
                    homePresenter.myFail(Constant.RESULT_NULL)
                return@async
            }
            homePresenter.mySuccess(result)
        }
    }
}