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
 * Created by Administrator on 2018\4\10 0010.
 * 构建为单列模式
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

    // kotlin的单例实现
    companion object {
        // 此处单例必须是val
        val instance: MyRetrofitHelper by lazy { MyRetrofitHelper() }
    }

    var retrofitService = getServer(
            MyConstant.REQUEST_BASE_URL
            , MyRetrofitInter::class.java)

    //创建我们的retroiftservice
    private fun <T> getServer(
            url: String
            , service: Class<T>
    ): T = myUrl(url)
            .create(service)

    private fun myUrl(url: String): Retrofit {
        // 创建 okHttpClientBuilder
        val builder = OkHttpClient().newBuilder()
                .apply {
                    connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    addInterceptor {
                        val request = it.request()
                        val response = it.proceed(request)
                        val requestUrl = request.url().toString()
                        val host = request.url().host()

                        // set-cookie maybe has multi, login to save cookie

                        val a = requestUrl.contains(SAVE_USER_LOGIN_KEY)
                        val b = requestUrl.contains(SAVE_USER_REGISTER_KEY)
                        val c = !response.headers(SET_COOKIE_KEY).isEmpty()

                        if (
                                (
//                                        requestUrl.contains(SAVE_USER_LOGIN_KEY)
                                        a
                                                ||
//                                                requestUrl.contains(SAVE_USER_REGISTER_KEY)
                                                b
                                        )
                                &&
//                                !response.headers(SET_COOKIE_KEY).isEmpty()
                                c
                        ) {
                            val header = response.headers(SET_COOKIE_KEY)
                            val cookie = encodeMyCookie(header)
                            saveMyCookie(requestUrl, host, cookie)
                        }

                        response
                    }

                    // set request cookie
                    addInterceptor {
                        val request = it.request()
                        val builder = request.newBuilder()
                        val domain = request.url().host()
                        // getInstance domain cookie
                        if (domain.isNotEmpty()) {
                            val spDomain: String by MyPreference(domain, "")
                            val cookie: String = if (spDomain.isNotEmpty()) spDomain else ""
                            if (cookie.isNotEmpty()) {
                                builder.addHeader(COOKIE_NAME, cookie)
                            }
                        }
                        it.proceed(builder.build())
                    }
                    // add log print
                    if (MyConstant.INTERCEPTOR_ENABLE) {
                        // loggingInterceptor
                        addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                            //                    loge(TAG, CONTENT_PRE + it)
                        }).apply {
                            // log level
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

//        MyRetrofitCreater(
//                url = url,
//                client = builder.build(),
//                gsonConver = GsonConverterFactory.myUrl(),
//                coroutine = CoroutineCallAdapterFactory()
//        ).retrofit
    }


    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    private fun saveMyCookie(url: String?, domain: String?, cookies: String) {

        // 这非空判断把人都看醉了
        url ?: return
        var spUrl: String by MyPreference(url, cookies)
        //        @Suppress("UNUSED_VALUE")
        spUrl = cookies

        domain ?: return
        var spDomain: String by MyPreference(domain, cookies)
        //        @Suppress("UNUSED_VALUE")
        spDomain = cookies

    }

}