package com.example.administrator.mykotlin.net.request

import com.example.administrator.mykotlin.constant.Constant
import com.example.administrator.mykotlin.net.RetrofitHelper
import com.example.administrator.mykotlin.persenter.TypePersenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypeRequest {
    var typeTree:Deferred<TreeListResponse>?=null
    fun getType(listen:TypePersenter){
        async(UI) {
            typeTree=RetrofitHelper.retrofitHelper.retrofitService.getTypeTreeList()
            var result=typeTree?.await()
            result?:let {
                listen.myFail(Constant.RESULT_NULL)
                return@async
            }
            listen.mySuccess(result)
        }
    }
}