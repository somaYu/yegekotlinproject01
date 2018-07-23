package com.example.administrator.mykotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.activity.WebActivity
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import top.jowanxu.wanandroidclient.bean.Datas

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class MyHomeAdapter(
        var context: Context?
        , var id: Int
        , var list: ArrayList<Datas>?
) : CommonAdapter<Datas>(context, id, list) {

    override fun convert(holder: ViewHolder?, datas: Datas?, position: Int) {

        holder?.setText(R.id.name, datas?.author)
        holder?.setText(R.id.time, datas?.niceDate)
        holder?.setText(R.id.content, datas?.title)
        holder?.setText(R.id.type, datas?.chapterName)

        //实现点击
        holder?.setOnClickListener(R.id.parent, View.OnClickListener {

            var intent = Intent(context, WebActivity::class.java)
            intent.putExtra("url", datas?.link)
            intent.putExtra("title", datas?.title)
            context?.startActivity(intent)

        })

    }

}