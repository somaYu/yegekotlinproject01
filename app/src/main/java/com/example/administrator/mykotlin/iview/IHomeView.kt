package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.HomeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
interface IHomeView {
    fun homeSuccess(result: HomeListResponseBean)
    fun homeFaile(meass:String?)
}