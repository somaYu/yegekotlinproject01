package com.example.administrator.mykotlin.activity

import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.BasePresenter

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 16:28
 */

class WebActivity : BaseActivity<BasePresenter>() {

    override fun getMyViewId(): Int {

        return R.layout.activity_web

    }

    override fun initMyPresenter() {
    }

    override fun initMyData() {
    }


}