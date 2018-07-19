package com.example.administrator.mykotlin.iview

import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
interface ITypeView {
    fun typeSucces(result: TreeListResponseBean)
    fun typeFaile(meass:String?)
}