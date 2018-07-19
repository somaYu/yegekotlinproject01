package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.base.BaseResponseBean

data class HomeListResponseBean(
    var errorCode: Int,
    var errorMsg: String?,
    var data: Data
) : BaseResponseBean()