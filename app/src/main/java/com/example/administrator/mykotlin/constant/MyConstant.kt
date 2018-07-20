package com.example.administrator.mykotlin.constant

import android.widget.Toast

/**
 * Created by Administrator on 2018\4\10 0010.
 */

// 使用object关键字替代class关键字就可以声明一个单例对象
object MyConstant {
    // 好像const并没有啥实际用处
    const val REQUEST_BASE_URL = "http://wanandroid.com/"
    const val SHARED_NAME = "_preferences"
    const val LOGIN_KEY = "login"
    const val USERNAME_KEY = "username"
    const val PASSWORD_KEY = "password"
    /**
     * result null
     */
    const val RESULT_NULL = "result null!"
    /**
     * Toast
     */
    @JvmField
    var showToast: Toast? = null
    /**
     * Debug
     */
    const val INTERCEPTOR_ENABLE = false
    /**
     * url key
     */
    const val CONTENT_URL_KEY = "url"
    /**
     * title key
     */
    const val CONTENT_TITLE_KEY = "title"
    /**
     * id key
     */
    const val CONTENT_ID_KEY = "id"
    /**
     * cid key
     */
    const val CONTENT_CID_KEY = "cid"
    /**
     * childrenData key
     */
    const val CONTENT_CHILDREN_DATA_KEY = "childrenData"
    /**
     * target key
     */
    const val CONTENT_TARGET_KEY = "target"
    /**
     * share key
     */
    const val CONTENT_SHARE_TYPE = "text/plain"
    const val SEARCH_KEY = "search"
    const val LIKE_KEY = "like"

    const val MAIN_REQUEST_CODE = 100
    const val MAIN_LIKE_REQUEST_CODE = 101
}