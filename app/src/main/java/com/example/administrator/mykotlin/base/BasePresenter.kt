package com.example.administrator.mykotlin.base

/**
 * Created by Administrator on 2018\4\11 0011.
 */
abstract class BasePresenter {
    abstract fun loginSuccess(responseBean: BaseResponseBean)
    abstract fun loginFail(s: String?)
}