package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.bean.BaseResponse
import com.example.administrator.mykotlin.iview.HomeView
import com.example.administrator.mykotlin.net.request.HomeRequest
import top.jowanxu.wanandroidclient.bean.HomeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class HomePresenter(var view:HomeView):BasePresenter() {

    fun getHome(page:Int){
        var request=HomeRequest()
        request.getHome(this,page)
    }
    override fun success(result: BaseResponse) {
        view.homeSuccess(result as HomeListResponse)
    }

    override fun faile(meassage: String?) {
        view.homeFaile(meassage)
    }
}