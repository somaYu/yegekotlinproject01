package com.example.administrator.mykotlin.net

import com.example.administrator.mykotlin.bean.LoginResponseBean
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 16:39
 */

// 请求方法注解
// 标记类注解
interface MyRetrofitInter {

    // 注册接口
    @POST("/user/register")
    @FormUrlEncoded
    fun regist(
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("repassword") repassowrd: String
    ): Deferred<LoginResponseBean>


    // 登陆接口
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
            @Field("username") username: String
            , @Field("password") password: String
    )
            : Deferred<LoginResponseBean>

}