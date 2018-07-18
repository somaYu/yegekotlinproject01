package com.example.administrator.mykotlin.adapter

import android.support.v4.app.FragmentActivity
import com.example.administrator.mykotlin.R
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypeAdapter(var context: FragmentActivity?, var id:Int, var datas:ArrayList<TreeListResponse.Data>):CommonAdapter<TreeListResponse.Data>(context,id,datas) {
    override fun convert(holder: ViewHolder?, t: TreeListResponse.Data?, position: Int) {
            holder?.setText(R.id.content,t?.name)
    }
}