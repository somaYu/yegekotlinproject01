package com.example.administrator.mykotlin.extend

import android.content.Context
import android.util.Log
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

fun Context.myToast(s: String, t: Int = Toast.LENGTH_SHORT) {

    Toast.makeText(getApplicationContext(), s, t).show()

}

// 搞到view的成员变量里
fun View.myVisible() {
    visibility = View.VISIBLE
}

fun View.myInVisible() {
    visibility = View.INVISIBLE
}

fun hehe(list: List<String>) {

    val sb = StringBuilder()
    val set = HashSet<String>()

    list.map { s ->

        s.split(",")

        Log.e("yy", "s=" + s)

    }


}

// 呵呵呵
fun encodeMyCookie(list: List<String>): String {

    var sb = StringBuilder()
    var set = HashSet<String>()

    // kotlin里的方法
    list.map {

        it.split(";".toRegex())

    }
            .forEach {

                // 这特么什么写法
                it.forEach {
                    set.add(it)
                }

            }

    val it = set.iterator()

    while (it.hasNext()) {
        val next = it.next()

        sb.append(next)
    }

    return sb.toString()

}


