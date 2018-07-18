package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.bean.BaseResponse

data class HomeListResponse(
    var errorCode: Int,
    var errorMsg: String?,
    var data: Data
):BaseResponse()