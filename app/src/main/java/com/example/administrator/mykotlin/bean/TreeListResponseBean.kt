package top.jowanxu.wanandroidclient.bean

import com.example.administrator.mykotlin.base.BaseResponseBean
import java.io.Serializable

data class TreeListResponseBean(
    var errorCode: Int,
    var errorMsg: String?,
    var data: ArrayList<Data>
) : BaseResponseBean() {
    data class Data(
        var id: Int,
        var name: String,
        var courseId: Int,
        var parentChapterId: Int,
        var order: Int,
        var visible: Int,
        var children: List<Children>?
    ) : Serializable {
        data class Children(
            var id: Int,
            var name: String,
            var courseId: Int,
            var parentChapterId: Int,
            var order: Int,
            var visible: Int,
            var children: List<Children>?
        ) : Serializable
    }
}