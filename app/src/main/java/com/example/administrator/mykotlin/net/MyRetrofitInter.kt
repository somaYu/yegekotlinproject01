package com.example.administrator.mykotlin.net

import com.example.administrator.mykotlin.bean.HomeListResponseBean
import com.example.administrator.mykotlin.bean.LoginResponseBean
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 16:39
 */

// 请求方法注解
// 标记类注解
interface MyRetrofitInter {

    // 注册
    @POST("/user/register")
    @FormUrlEncoded
    fun regist(
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("repassword") repassowrd: String
    ): Deferred<LoginResponseBean>


    // 登陆
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
            @Field("username") username: String
            , @Field("password") password: String
    )
            : Deferred<LoginResponseBean>

    // 首页
    @GET("article/list/{page}/json")
    fun getHomeList(
            @Path("page") page: Int
    ): Deferred<HomeListResponseBean>

}