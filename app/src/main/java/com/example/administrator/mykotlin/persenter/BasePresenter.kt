package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.bean.BaseResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
abstract class BasePresenter {
    abstract fun success(result:BaseResponse)
    abstract fun faile(meassage:String?)
}