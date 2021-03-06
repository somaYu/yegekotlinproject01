package com.example.administrator.mykotlin.activity

import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.BasePresenter
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web.*

/**
 * Created by Administrator on 2018\4\16 0016.
 */
class WebActivity : BaseActivity<BasePresenter>() {
    override fun getMyViewId(): Int = R.layout.activity_web

    override fun initMyPresenter() {
    }

    override fun initMyData() {
       var url= intent.getStringExtra("url")
        var title=intent.getStringExtra("title")
        toolbar02.title=title
        setSupportActionBar(toolbar02)
        AgentWeb.with(this)
                .setAgentWebParent((web as FrameLayout),LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url)
    }
}