package com.example.administrator.mykotlin.bean

import com.example.administrator.mykotlin.base.BaseResponseBean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:31
 */

data class HomeListResponseBean(

        var errorCode: Int
        , var errorMsg: String?
        , var data: HomeListData

) : BaseResponseBean()