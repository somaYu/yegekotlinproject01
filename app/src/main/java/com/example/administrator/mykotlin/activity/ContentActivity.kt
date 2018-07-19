package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.MyViewPagerAdapter
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.fragment.IHomeFragment
import com.example.administrator.mykotlin.fragment.ITypeFragment
import com.example.administrator.mykotlin.persenter.ContentPresenter
import com.example.administrator.mykotlin.util.MySpUtil
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.include_content.*

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class ContentActivity : BaseActivity<ContentPresenter>() {

    var titles=ArrayList<String>()
    var fragmes=ArrayList<Fragment>()
    override fun getMyViewId(): Int = R.layout.activity_content


    override fun initMyPresenter() {
    }

    override fun initMyData() {
        //toolbar设置标题
        toolbar.title="Kotlin Demo"
        //toolbar设置长actionbar
        setSupportActionBar(toolbar)
        titles.add("首页")
        titles.add("知识体系")
        fragmes.add(IHomeFragment())
        fragmes.add(ITypeFragment())
        viewpager.adapter= MyViewPagerAdapter(supportFragmentManager,fragmes,titles)
        tablayout.setupWithViewPager(viewpager)
        //设置用户名
        name.text = MySpUtil.instance.getInstance(this).getString("name", "")
        //退出登陆
        exit.setOnClickListener(onClickListener)
    }

    private var onClickListener= View.OnClickListener {
        View->when(View.id){
        R.id.exit->{
            startActivity(Intent(this@ContentActivity, ILoginActivity::class.java))
            MySpUtil.instance.getInstance(this@ContentActivity).putBoolean("sign", false)
            finish()
        }
    }

    }
}