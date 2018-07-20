package com.example.administrator.mykotlin.bean

import com.example.administrator.mykotlin.base.BaseResponseBean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 14:31
 */

// 一个data关键字就代表了bean对象的意思？
// 好高大上的bean对象
data class LoginResponseBean(

        var dataBean: DataBean
        , var errorMsg: String
        , var errorCode: Int

)

    : BaseResponseBean() {

}
