package com.example.administrator.mykotlin.persenter

import com.example.administrator.mykotlin.bean.BaseResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
abstract class BasePresenter {
    abstract fun mySuccess(response: BaseResponse)
    abstract fun myFail(error: String?)
}