package com.example.administrator.mykotlin.bean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:33
 */

data class HomeListData(
        var offset: Int
        , var size: Int
        , var total: Int
        , var pageCount: Int
        , var curPage: Int
        , var over: Boolean
        , var datas: ArrayList<Datas>?
)

