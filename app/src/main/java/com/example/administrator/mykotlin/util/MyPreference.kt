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
    private fun <U> setMyPreference(name: String, default: U): U = with(preferences) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }
        res as U
    }

    @SuppressLint("CommitPrefEdits")
    private fun <U> putMyPreference(name: String, value: U) = with(preferences.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }
}