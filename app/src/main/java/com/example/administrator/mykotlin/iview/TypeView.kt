package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
interface TypeView {
    fun typeSucces(result:TreeListResponse)
    fun typeFaile(meass:String?)
}