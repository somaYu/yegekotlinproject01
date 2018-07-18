package com.example.administrator.mykotlin.extend

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Created by Administrator on 2018\4\10 0010.
 * Kotlin的扩展函数
 * 注意 ：没有类名
 * 只是一个方法的集合区
 *
 * 创建方式类似于java的静态方法
 * 有一个类型限制 只有这个类型才能调用这个方法
 */
fun Context.toast(meass:String,time:Int=Toast.LENGTH_SHORT){
    Toast.makeText(this,meass,time).show()
}

fun View.invisible(){
    //将属性值赋值给当前属性
    visibility=View.INVISIBLE
}

fun View.visible(){
    visibility=View.VISIBLE
}
fun encodeCookie(cookies: List<String>): String {
    val sb = StringBuilder()
    val set = HashSet<String>()
    cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }

    val ite = set.iterator()
    while (ite.hasNext()) {
        val cookie = ite.next()
        sb.append(cookie).append(";")
    }

    val last = sb.lastIndexOf(";")
    if (sb.length - 1 == last) {
        sb.deleteCharAt(last)
    }

    return sb.toString()
}

