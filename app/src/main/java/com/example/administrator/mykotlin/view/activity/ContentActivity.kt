package com.example.administrator.mykotlin.view.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.MyViewPagerAdapter
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.SharedpresferenesUtils
import com.example.administrator.mykotlin.persenter.ContentPresenter
import com.example.administrator.mykotlin.view.activity.fragment.HomeFragment
import com.example.administrator.mykotlin.view.activity.fragment.TypeFragment
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.include_content.*

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class ContentActivity : BaseActivity<ContentPresenter>() {

    var titles=ArrayList<String>()
    var fragmes=ArrayList<Fragment>()
    override fun getViewId(): Int =R.layout.activity_content


    override fun initPresenter() {
    }

    override fun initData() {
        //toolbar设置标题
        toolbar.title="Kotlin Demo"
        //toolbar设置长actionbar
        setSupportActionBar(toolbar)
        titles.add("首页")
        titles.add("知识体系")
        fragmes.add(HomeFragment())
        fragmes.add(TypeFragment())
        viewpager.adapter= MyViewPagerAdapter(supportFragmentManager,fragmes,titles)
        tablayout.setupWithViewPager(viewpager)
        //设置用户名
        name.text=SharedpresferenesUtils.shared.get(this).getString("name","")
        //退出登陆
        exit.setOnClickListener(onClickListener)
    }

    private var onClickListener= View.OnClickListener {
        View->when(View.id){
        R.id.exit->{
            startActivity(Intent(this@ContentActivity,LoginActivity::class.java))
            SharedpresferenesUtils.shared.get(this@ContentActivity).putBoolean("sign",false)
            finish()
        }
    }

    }
}