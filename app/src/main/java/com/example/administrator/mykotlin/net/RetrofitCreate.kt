package com.example.administrator.mykotlin.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 2018\4\10 0010.
 */
class RetrofitCreate(url:String,clien:OkHttpClient,gsonConver:GsonConverterFactory,coroutine:CoroutineCallAdapterFactory ) {
    var reterofit=Retrofit.Builder().apply {
        baseUrl(url)
        client(clien)
        addConverterFactory(gsonConver)
        addCallAdapterFactory(coroutine)
    }.build()
}