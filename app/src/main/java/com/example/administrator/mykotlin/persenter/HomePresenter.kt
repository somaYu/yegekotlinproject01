package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.base.BaseResponseBean
import com.example.administrator.mykotlin.iview.IHomeView
import com.example.administrator.mykotlin.request.HomeRequest
import top.jowanxu.wanandroidclient.bean.HomeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class HomePresenter(var viewI: IHomeView) : BasePresenter() {

    fun getHome(page:Int){
        var request=HomeRequest()
        request.getHome(this,page)
    }

    override fun mySuccess(responseBean: BaseResponseBean) {
        viewI.homeSuccess(responseBean as HomeListResponseBean)
    }

    override fun myFail(s: String?) {
        viewI.homeFaile(s)
    }
}