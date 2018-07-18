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

    companion object {
        // 并不是所有的val都能用var代替，比如单例
        val instance: MySpUtil by lazy { MySpUtil() }
    }

    fun getInstance(context: Context): MySpUtil {

        sp = context.getSharedPreferences("yege002", Context.MODE_PRIVATE)
        editor = sp?.edit()

        return this
    }


}

