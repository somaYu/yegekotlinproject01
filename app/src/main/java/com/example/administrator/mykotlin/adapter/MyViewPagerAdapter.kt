package com.example.administrator.mykotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 16:33
 */

class MyViewPagerAdapter(

        var fm: FragmentManager
        , var list1: List<String>
        , var list2: List<Fragment>

) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return list1.get(position)
    }

    override fun getItem(position: Int): Fragment {
        return list2.get(position)
    }

    override fun getCount(): Int {
        return list2.size
    }

}