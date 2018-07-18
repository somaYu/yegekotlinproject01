package com.example.administrator.mykotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.mykotlin.persenter.BasePresenter

/**
 * Created by Administrator on 2018\4\11 0011.
 */
abstract class BaseActivity<T:BasePresenter>:AppCompatActivity(){
    var mPreasenter:T?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewId())
        initPresenter()
        initData()
    }

    abstract fun getViewId(): Int

    abstract fun initPresenter()

    abstract fun initData()
}