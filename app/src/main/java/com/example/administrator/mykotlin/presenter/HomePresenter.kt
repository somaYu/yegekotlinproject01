package com.example.administrator.mykotlin.presenter

import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.base.BaseResponseBean
import com.example.administrator.mykotlin.bean.HomeListResponseBean
import com.example.administrator.mykotlin.iview.IHomeView
import com.example.administrator.mykotlin.request.HomeRequest

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:46
 */

class HomePresenter(var iView: IHomeView) : BasePresenter() {

    override fun loginSuccess(responseBean: BaseResponseBean) {

        // 向下转型用as
        iView.homeSuccess(responseBean as HomeListResponseBean)

    }

    override fun loginFail(s: String) {

        iView.homeFail(s)

    }

    fun getHome(page: Int) {

        val request = HomeRequest()

        request.getHome(this, page)

    }


}
