package com.example.administrator.mykotlin.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.administrator.mykotlin.constant.MyConstant
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2018\4\11 0011.
 */

class MyPreference<T>(private val name: String, private val default: T) : ReadWriteProperty<Any?, T> {

    companion object {
        // lateinit修饰符只能修饰不可空类型
        lateinit var preferences: SharedPreferences

        fun setMyContext(context: Context) {
            preferences = context.getSharedPreferences(
                    context.packageName + MyConstant.SHARED_NAME
                    , Context.MODE_PRIVATE
            )
        }

        fun myClear() {
            preferences.edit().clear().apply()
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = setMyPreference(name, default)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putMyPreference(name, value)

    @Suppress("UNCHECKED_CAST")
    private fun <U> setMyPreference(k: String, v: U): U = with(preferences) {

        val res: Any = when (v) {
            is Long -> getLong(k, v)
            is String -> getString(k, v)
            is Int -> getInt(k, v)
            is Boolean -> getBoolean(k, v)
            is Float -> getFloat(k, v)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }

        res as U

    }

    @SuppressLint("CommitPrefEdits")
    private fun <U> putMyPreference(k: String, v: U) = with(preferences.edit()) {

        when (v) {
            is Long -> putLong(k, v)
            is String -> putString(k, v)
            is Int -> putInt(k, v)
            is Boolean -> putBoolean(k, v)
            is Float -> putFloat(k, v)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()

    }

}