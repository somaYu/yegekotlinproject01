package com.example.administrator.mykotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class MyViewPagerAdapter(
        var fm: FragmentManager
        , var list1: List<String>

        , var list2: List<Fragment>
) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence {
        return list1.get(position)
    }

    override fun getItem(position: Int): Fragment = list2.get(position)

    override fun getCount(): Int = list2.size

}