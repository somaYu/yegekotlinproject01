package com.example.administrator.mykotlin.net

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*
import top.jowanxu.wanandroidclient.bean.HomeListResponse
import top.jowanxu.wanandroidclient.bean.LoginResponse
import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\11 0011.
 */
interface RetrofitService {
    /*
    登陆
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
            @Field("username") username: String,
            @Field("password") password: String
    ): Deferred<LoginResponse>

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */

    @GET("/article/list/{page}/json")
    fun getHomeList(
            @Path("page") page: Int
    ): Deferred<HomeListResponse>

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    fun getTypeTreeList(): Deferred<TreeListResponse>

    /**
     * 注册
     * @param username username
     * @param password password
     * @param repassword repassword
     * @return Deferred<LoginResponse>
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun register(
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("repassword") repassowrd: String
    ): Deferred<LoginResponse>
}