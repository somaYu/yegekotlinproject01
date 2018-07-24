package com.example.administrator.mykotlin.util

import android.content.Context
import android.content.SharedPreferences

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/18 16:18
 */

// 这个单例真是让我醉了
// 私有化构造函数
class MySpUtil private constructor() {

    private var sp: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    // kotlin伴生对象
    companion object {
        // 并不是所有的val都能用var代替，比如单例
        val instance: MySpUtil by lazy { MySpUtil() }
    }

    // return可以用=代替
    fun getInstance(context: Context): MySpUtil {

        sp = context.getSharedPreferences("yege002", Context.MODE_PRIVATE)
        editor = sp?.edit()

        return this
    }

    fun putBoolean(k: String, v: Boolean) {
        editor?.putBoolean(k, v)?.commit()
    }

    fun getBoolean(k: String, v: Boolean): Boolean {
        return sp?.getBoolean(k, v)!!
    }

    fun putString(k: String, v: String) {
        editor?.putString(k, v)?.commit()
    }

    fun getString(k: String, v: String): String {
        return sp?.getString(k, v)!!
    }

}

