package com.example.administrator.mykotlin.adapter

import android.support.v4.app.FragmentActivity
import com.example.administrator.mykotlin.R
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class MyTypeAdapter(var context: FragmentActivity?, var id: Int, var datas: ArrayList<TreeListResponseBean.Data>) : CommonAdapter<TreeListResponseBean.Data>(context, id, datas) {
    override fun convert(holder: ViewHolder?, t: TreeListResponseBean.Data?, position: Int) {
            holder?.setText(R.id.content,t?.name)
    }
}