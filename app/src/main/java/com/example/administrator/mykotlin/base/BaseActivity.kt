package com.example.administrator.mykotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/18 15:56
 */

// 呵呵呵
abstract class BaseActivity<T : BasePresenter> : AppCompatActivity() {

    // ? 当前对象可以为空
    var basePresenter: T? = null

    // 千万别掉进两个参数的大坑
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getMyViewId())

        initMyPresenter()

        initMyData()

    }

    // 返回时Int型
    abstract fun getMyViewId(): Int

    abstract fun initMyPresenter()

    abstract fun initMyData()


}