package com.example.administrator.mykotlin.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created by Administrator on 2018\4\12 0012.
 */
abstract class BaseFragment<T : BasePresenter> : Fragment() {
    var mPresenter: T? = null
    var pd: ProgressDialog? = null
    // 呵呵呵呵呵
//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initMyFragmentView(inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 居然直接就context
        pd = ProgressDialog(context)
//        pd.setProgressStyle(ProgressDialog.)
        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT)

        params.gravity = Gravity.TOP

        initMyPresneter()
        initMyDatas()
    }

    abstract fun initMyFragmentView(inflater: LayoutInflater?, container: ViewGroup?): View?

    abstract fun initMyDatas()

    abstract fun initMyPresneter()

    fun myShow() {
        pd?.show()
    }

    fun myHide() {
        pd?.dismiss()
    }

}