package com.example.administrator.mykotlin.bean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 14:33
 */


data class DataBean(

        var id: Int
        , var username: String
        , var password: String
        , var icon: String
        , var type: Int
        , var collectIds: List<Int>

)