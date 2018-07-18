package com.example.administrator.mykotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class MyViewPagerAdapter(var fm:FragmentManager,var fragments:List<Fragment>,var titles:List<String>):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment=fragments.get(position)

    override fun getCount(): Int=fragments.size

    override fun getPageTitle(position: Int): CharSequence {
        return titles.get(position)
    }
}