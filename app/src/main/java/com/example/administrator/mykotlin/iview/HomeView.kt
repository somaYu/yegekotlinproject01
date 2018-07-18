package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.HomeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
interface HomeView {
    fun homeSuccess(result: HomeListResponse)
    fun homeFaile(meass:String?)
}