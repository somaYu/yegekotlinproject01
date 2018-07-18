package com.example.administrator.mykotlin.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Administrator on 2018\4\16 0016.
 */
class MySpUtil private constructor() {

    private var sp: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    companion object {
        val instance: MySpUtil by lazy { MySpUtil() }
    }

    fun getInstance(context: Context): MySpUtil {
//        sp = context.getSharedPreferences("yege001", 0)
        sp = context.getSharedPreferences("yege001", Context.MODE_PRIVATE)
        editor = sp?.edit()
        return this
    }

    fun getBoolean(k: String, v: Boolean): Boolean = sp?.getBoolean(k, v)!!

    fun putBoolean(k: String, v: Boolean) {
        editor?.putBoolean(k, v)?.commit()
    }

    fun getString(k: String, v: String): String = sp?.getString(k, v)!!

    fun putString(k: String, v: String) {
        editor?.putString(k, v)?.commit()
    }

}