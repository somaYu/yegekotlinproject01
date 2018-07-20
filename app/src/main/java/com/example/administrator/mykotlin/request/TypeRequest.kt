package com.example.administrator.mykotlin.request

import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.net.MyRetrofitHelper
import com.example.administrator.mykotlin.persenter.TypePersenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypeRequest {
    var typeTree: Deferred<TreeListResponseBean>? = null
    fun getType(listen:TypePersenter){
        async(UI) {
            typeTree = MyRetrofitHelper.instance.interR.getTypeTreeList()
            var result=typeTree?.await()
            result?:let {
                listen.loginFail(MyConstant.RESULT_NULL)
                return@async
            }
            listen.loginSuccess(result)
        }
    }
}