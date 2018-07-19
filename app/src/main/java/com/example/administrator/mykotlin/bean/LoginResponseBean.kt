package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.base.BaseResponseBean

// 好高大上的bean对象
data class LoginResponseBean(
        var errorCode: Int
        , var errorMsg: String?
        , var dataBean: DataBean
) : BaseResponseBean() {
    data class DataBean(
            var id: Int
            , var username: String
            , var password: String
            , var icon: String?
            , var type: Int
            , var collectIds: List<Int>?
    )
}