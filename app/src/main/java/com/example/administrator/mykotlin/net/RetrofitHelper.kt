package com.example.administrator.mykotlin.net

import com.example.administrator.mykotlin.base.Preference
import com.example.administrator.mykotlin.constant.Constant
import com.example.administrator.mykotlin.encodeCookie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2018\4\10 0010.
 * 构建为单列模式
 */
class RetrofitHelper private constructor(){

    private  val TAG = "RetrofitHelper"
    private  val CONTENT_PRE = "OkHttp: "
    private  val SAVE_USER_LOGIN_KEY = "user/login"
    private  val SAVE_USER_REGISTER_KEY = "user/register"
    private  val SET_COOKIE_KEY = "set-cookie"
    private  val COOKIE_NAME = "Cookie"
    private  val CONNECT_TIMEOUT = 30L
    private  val READ_TIMEOUT = 10L
    //kotlin的单列实现
    companion object {
        val retrofitHelper:RetrofitHelper by lazy { RetrofitHelper() }
    }

    var retrofitService= getServer(Constant.REQUEST_BASE_URL,RetrofitService::class.java)

    //创建我们的retroiftservice
   private fun <T>getServer(url:String,service:Class<T>):T=create(url).create(service)

    private fun create(url: String): Retrofit {
        // 创建 okHttpClientBuilder
        val okHttpClientBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            // 获取response cookie
            addInterceptor {
                val request = it.request()
                val response = it.proceed(request)
                val requestUrl = request.url().toString()
                val domain = request.url().host()
                // set-cookie maybe has multi, login to save cookie
                if ((requestUrl.contains(SAVE_USER_LOGIN_KEY) || requestUrl.contains(
                        SAVE_USER_REGISTER_KEY
                ))
                        && !response.headers(SET_COOKIE_KEY).isEmpty()) {
                    val cookies = response.headers(SET_COOKIE_KEY)
                    val cookie = encodeCookie(cookies)
                    saveCookie(requestUrl, domain, cookie)
                }
                response
            }
            // set request cookie
            addInterceptor {
                val request = it.request()
                val builder = request.newBuilder()
                val domain = request.url().host()
                // get domain cookie
                if (domain.isNotEmpty()) {
                    val spDomain: String by Preference(domain, "")
                    val cookie: String = if (spDomain.isNotEmpty()) spDomain else ""
                    if (cookie.isNotEmpty()) {
                        builder.addHeader(COOKIE_NAME, cookie)
                    }
                }
                it.proceed(builder.build())
            }
            // add log print
            if (Constant.INTERCEPTOR_ENABLE) {
                // loggingInterceptor
                addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
//                    loge(TAG, CONTENT_PRE + it)
                }).apply {
                    // log level
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }

        return RetrofitCreate(
                url = url,
                clien = okHttpClientBuilder.build(),
                gsonConver = GsonConverterFactory.create(),
                coroutine = CoroutineCallAdapterFactory()
        ).reterofit
    }

    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    private fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        var spUrl: String by Preference(url, cookies)
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        domain ?: return
        var spDomain: String by Preference(domain, cookies)
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
    }

}