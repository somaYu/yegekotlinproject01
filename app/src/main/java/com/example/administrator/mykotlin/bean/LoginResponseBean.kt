package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.base.BaseResponseBean

// 好高大上的bean对象
data class LoginResponseBean(
        var errorCode: Int
        , var errorMsg: String?
        // 这个地方如果改字段名，则会出错
        , var data: DataBean
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