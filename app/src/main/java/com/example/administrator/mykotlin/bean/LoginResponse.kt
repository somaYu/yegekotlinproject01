package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.bean.BaseResponse

data class LoginResponse(
    var errorCode: Int,
    var errorMsg: String?,
    var data: Data
):BaseResponse() {
    data class Data(
        var id: Int,
        var username: String,
        var password: String,
        var icon: String?,
        var type: Int,
        var collectIds: List<Int>?
    )
}