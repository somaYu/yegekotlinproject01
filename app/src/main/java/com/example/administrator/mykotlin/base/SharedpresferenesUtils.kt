package com.example.administrator.mykotlin.base

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Administrator on 2018\4\16 0016.
 */
class SharedpresferenesUtils private constructor() {
    private var edit:SharedPreferences.Editor?=null
    private var sharedPreferences:SharedPreferences?=null
    companion object {
        val shared:SharedpresferenesUtils by lazy { SharedpresferenesUtils() }
    }
    fun get(context: Context):SharedpresferenesUtils{
        sharedPreferences = context.getSharedPreferences("dahei", 0)
        edit = sharedPreferences?.edit()
        return this
    }

    fun getBoolean(key:String,value:Boolean):Boolean=sharedPreferences?.getBoolean(key,value)!!

    fun putBoolean(key:String,value:Boolean){
        edit?.putBoolean(key,value)?.commit()
    }

    fun getString(key:String,value:String):String=sharedPreferences?.getString(key,value)!!

    fun putString(key:String,value:String){
        edit?.putString(key,value)?.commit()
    }
}