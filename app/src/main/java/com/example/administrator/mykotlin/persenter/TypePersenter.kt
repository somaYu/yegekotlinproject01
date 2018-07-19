package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.base.BaseResponseBean
import com.example.administrator.mykotlin.iview.ITypeView
import com.example.administrator.mykotlin.request.TypeRequest
import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypePersenter(var viewI: ITypeView) : BasePresenter() {

    fun getType(){
        var request=TypeRequest()
        request.getType(this)
    }

    override fun mySuccess(responseBean: BaseResponseBean) {
        viewI.typeSucces(responseBean as TreeListResponseBean)
    }

    override fun myFail(s: String?) {
        viewI.typeFaile(s)
    }
}