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
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:38
 */

abstract class BaseFragment<T : BasePresenter> : Fragment() {

    var mPresenter: T? = null

    var pd: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initMyFragmentView(inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pd = ProgressDialog(context);

        val params = LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT

        )

        params.gravity = Gravity.TOP

        initMyPresenter();

        initMyDatas()

    }

    abstract fun initMyFragmentView(inflater: LayoutInflater, container: ViewGroup?): View?

    abstract fun initMyPresenter()

    abstract fun initMyDatas()

    fun myShow() {
        pd?.show()
    }

    fun myHide() {
        pd?.dismiss()
    }

}
