package com.example.administrator.mykotlin.iview

import com.example.administrator.mykotlin.bean.HomeListResponseBean

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:31
 */
interface IHomeView {

    fun homeSuccess(result: HomeListResponseBean)
    fun homeFail(s: String)

}