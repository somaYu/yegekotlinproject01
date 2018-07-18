package com.example.administrator.mykotlin.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.administrator.mykotlin.persenter.BasePresenter

/**
 * Created by Administrator on 2018\4\12 0012.
 */
abstract class BaseFragment<T : BasePresenter> : Fragment() {
    var mPresenter: T? = null
    var progress: ProgressDialog? = null
    // 呵呵呵呵呵
//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getMyView(inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progress = ProgressDialog(context)
//        progress.setProgressStyle(ProgressDialog.)
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.gravity = Gravity.TOP

        initPresneter()
        initDatas()
    }

    abstract fun getMyView(inflater: LayoutInflater?, container: ViewGroup?): View?

    abstract fun initDatas()

    abstract fun initPresneter()

    fun show() {
        progress?.show()
    }

    fun hidden() {
        progress?.dismiss()
    }

}