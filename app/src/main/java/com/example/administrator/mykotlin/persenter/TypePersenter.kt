package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.bean.BaseResponse
import com.example.administrator.mykotlin.iview.TypeView
import com.example.administrator.mykotlin.net.request.TypeRequest
import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypePersenter(var view:TypeView):BasePresenter() {

    fun getType(){
        var request=TypeRequest()
        request.getType(this)
    }

    override fun mySuccess(response: BaseResponse) {
        view.typeSucces(response as TreeListResponse)
    }

    override fun myFail(error: String?) {
        view.typeFaile(error)
    }
}