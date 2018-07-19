package com.example.administrator.mykotlin.net

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*
import top.jowanxu.wanandroidclient.bean.HomeListResponseBean
import top.jowanxu.wanandroidclient.bean.LoginResponseBean
import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\11 0011.
 */
interface MyRetrofitInter {
    /*
    登陆
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
            @Field("username") username: String
            , @Field("password") password: String
    )
            : Deferred<LoginResponseBean>

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */

    @GET("/article/list/{page}/json")
    fun getHomeList(
            @Path("page") page: Int
    ): Deferred<HomeListResponseBean>

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    fun getTypeTreeList(): Deferred<TreeListResponseBean>

    /**
     * 注册
     * @param username username
     * @param password password
     * @param repassword repassword
     * @return Deferred<LoginResponseBean>
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun register(
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("repassword") repassowrd: String
    ): Deferred<LoginResponseBean>
}