package com.example.administrator.mykotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.view.activity.WebActivity
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import top.jowanxu.wanandroidclient.bean.Datas

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class MyHomeAdapter(var context: Context?, var id:Int, var datas:ArrayList<Datas>?):CommonAdapter<Datas>(context,id,datas) {
    override fun convert(holder: ViewHolder?, t: Datas?, position: Int) {
            holder?.setText(R.id.name,t?.author)
        holder?.setText(R.id.time,t?.niceDate)
        holder?.setText(R.id.content,t?.title)
        holder?.setText(R.id.type,t?.chapterName)
        //实现点击
        holder?.setOnClickListener(R.id.parent, View.OnClickListener {
            var intent=Intent(context, WebActivity::class.java)
            intent.putExtra("url",t?.link)
            intent.putExtra("title",t?.title)
            context?.startActivity(intent)
        })

    }
}