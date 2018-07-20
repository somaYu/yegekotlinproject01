package com.example.administrator.mykotlin.net

import com.example.administrator.mykotlin.constant.MyConstant
import com.example.administrator.mykotlin.extend.encodeMyCookie
import com.example.administrator.mykotlin.util.MyPreference
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 16:46
 */

class MyRetrofitHelper private constructor() {

    private val TAG = "MyRetrofitHelper"
    private val CONTENT_PRE = "OkHttp: "
    private val SAVE_USER_LOGIN_KEY = "user/login"
    private val SAVE_USER_REGISTER_KEY = "user/register"
    private val SET_COOKIE_KEY = "set-cookie"
    private val COOKIE_NAME = "Cookie"
    private val CONNECT_TIMEOUT = 30L
    private val READ_TIMEOUT = 10L

    // kotlin单例就这么写
    companion object {

        // 此处单例必须是val
        val instance: MyRetrofitHelper by lazy { MyRetrofitHelper() }
    }

    // 获取retrofit
    fun getRetrofit(
            url: String
            , client: OkHttpClient
            , gsonConver: GsonConverterFactory
            , coroutine: CoroutineCallAdapterFactory
    ): Retrofit {

        var retrofit = Retrofit.Builder()
                .apply {
                    baseUrl(url)
                    client(client)
                    addConverterFactory(gsonConver)
                    addCallAdapterFactory(coroutine)
                }
                .build()

        return retrofit
    }

    fun myUrl(url: String): Retrofit {

        val builder = OkHttpClient().newBuilder()
                .apply {
                    connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    addInterceptor {

                        val request = it.request()
                        val response = it.proceed(request)
                        val requestUrl = request.url().toString()
                        val host = request.url().host()

                        // 设置cookie001，登陆保存cookie
                        val a = requestUrl.contains(SAVE_USER_LOGIN_KEY)
                        val b = requestUrl.contains(SAVE_USER_REGISTER_KEY)
                        val c = !response.headers(SET_COOKIE_KEY).isEmpty()

                        if ((a || b) && c) {

                            val header = response.headers(SET_COOKIE_KEY)
                            val cookie = encodeMyCookie(header)
                            saveMyCookie(requestUrl, host, cookie)
                        }

                        response
                    }

                    // 设置request cookie002
                    addInterceptor {

                        val request = it.request()
                        val builder = request.newBuilder()
                        val host = request.url().host()

                        if (host.isNotEmpty()) {

                            val spDomain: String by MyPreference(host, "")

                            val cookie: String = if (spDomain.isNotEmpty()) spDomain else ""

                            if (cookie.isNotEmpty()) {
                                builder.addHeader(COOKIE_NAME, cookie)
                            }

                        }
                        it.proceed(builder.build())
                    }

                    // 添加log
                    if (MyConstant.INTERCEPTOR_ENABLE) {

                        addInterceptor(
                                HttpLoggingInterceptor(
                                        HttpLoggingInterceptor.Logger {

                                        }).apply {

                                    level = HttpLoggingInterceptor.Level.BODY

                                })
                    }

                }

        var retrofit = Retrofit.Builder()
                .apply {

                    baseUrl(url)
                    client(builder.build())
                    addConverterFactory(GsonConverterFactory.create())
                    addCallAdapterFactory(CoroutineCallAdapterFactory())
                }
                .build()

        return retrofit

    }

    fun saveMyCookie(
            s1: String?
            , s2: String?
            , cookies: String
    ) {

        // 这非空判断把人都看醉了
        s1 ?: return
        var spS1: String by MyPreference(s1, cookies)
        spS1 = cookies

        s2 ?: return
        var spS2: String by MyPreference(s2, cookies)
        spS2 = cookies

    }

}