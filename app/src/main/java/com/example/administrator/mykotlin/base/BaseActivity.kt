package com.example.administrator.mykotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.mykotlin.persenter.BasePresenter

/**
 * Created by Administrator on 2018\4\11 0011.
 */
abstract class BaseActivity<T : BasePresenter> : AppCompatActivity() {

    var basePreasenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getMyViewId())

        initMyPresenter()

        initMyData()

    }

    abstract fun getMyViewId(): Int

    abstract fun initMyPresenter()

    abstract fun initMyData()
}