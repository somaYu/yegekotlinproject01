package com.example.administrator.mykotlin.util

import android.content.Context
import android.content.SharedPreferences
import com.example.administrator.mykotlin.constant.MyConstant
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 17:51
 */

class MyPreference<T>(private val name: String, private val default: T) : ReadWriteProperty<Any?, T> {

    companion object {
        // lateinit修饰符只能修饰不可空类型
        lateinit var preference: SharedPreferences

        fun setMyContext(context: Context) {
            preference = context.getSharedPreferences(
                    context.packageName + MyConstant.SHARED_NAME
                    , Context.MODE_PRIVATE
            )
        }

        fun myClear() {
            preference.edit().clear().apply()
        }
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return setMyPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        return putMyPreference(name, default)
    }

    // 看不懂
    // 这函数把人都看醉了，啥玩意
    fun <U> setMyPreference(k: String, v: U): U = with(preference) {

        val res: Any = when (v) {
            is Long -> getLong(k, v)
            is String -> getString(k, v)
            is Int -> getInt(k, v)
            is Boolean -> getBoolean(k, v)
            is Float -> getFloat(k, v)
            else -> throw IllegalAccessException("setMyPreference异常")
        }

        res as U
    }

    fun <U> putMyPreference(k: String, v: U) = with(preference.edit()) {

        when (v) {

            is Long -> putLong(k, v)
            is String -> putString(k, v)
            is Int -> putInt(k, v)
            is Boolean -> putBoolean(k, v)
            is Float -> putFloat(k, v)
            else -> throw IllegalAccessException("putMyPreference异常")

        }.apply()

    }

}