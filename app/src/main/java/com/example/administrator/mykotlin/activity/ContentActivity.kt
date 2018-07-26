package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.MyViewPagerAdapter
import com.example.administrator.mykotlin.base.BaseActivity
import com.example.administrator.mykotlin.base.BasePresenter
import com.example.administrator.mykotlin.fragment.HomeFragment
import com.example.administrator.mykotlin.util.MySpUtil
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.include_content.*

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 9:43
 */
// 改造之前备份
class ContentActivity : BaseActivity<BasePresenter>() {

    var list1 = ArrayList<String>()
    var list2 = ArrayList<Fragment>()

    override fun getMyViewId(): Int {
        return R.layout.activity_content
    }

    override fun initMyPresenter() {
    }

    override fun initMyData() {

        toolbar.title = "yege test"
        setSupportActionBar(toolbar)

        list1.add("首页")
        list1.add("知识体系")

        list2.add(HomeFragment())
        list2.add(HomeFragment())

        viewpager.adapter = MyViewPagerAdapter(

                supportFragmentManager
                , list1
                , list2

        )

        tablayout.setupWithViewPager(viewpager)

        name.text = MySpUtil.instance.getInstance(this)
                .getString("name", "")


    }

    var listener = View.OnClickListener {

        when (it.id) {

            R.id.exit -> {

                startActivity(Intent(this@ContentActivity, LoginActivity::class.java))

                MySpUtil.instance.getInstance(this@ContentActivity)
                        .putBoolean("sign", false)

                finish()

            }

        }

    }


}