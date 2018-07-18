package com.example.administrator.mykotlin.base

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/18 15:52
 */

// 根据业务想出来的基类
abstract class BasePresenter {

    abstract fun mySuccesss(response: BaseResponse)

    abstract fun myFail(error: String)

}


