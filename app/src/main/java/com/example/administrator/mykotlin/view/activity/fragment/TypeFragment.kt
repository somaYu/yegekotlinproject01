package com.example.administrator.mykotlin.view.activity.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.TypeAdapter
import com.example.administrator.mykotlin.base.BaseFragment
import com.example.administrator.mykotlin.iview.TypeView
import com.example.administrator.mykotlin.persenter.TypePersenter
import kotlinx.android.synthetic.main.fragment_type.*
import top.jowanxu.wanandroidclient.bean.TreeListResponse

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class TypeFragment : BaseFragment<TypePersenter>(), TypeView {
    override fun typeSucces(result: TreeListResponse) {
        ty_recycler.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = TypeAdapter(activity, R.layout.item_home, result?.data)
        }
    }

    override fun typeFaile(meass: String?) {

    }

    override fun getMyView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        return inflater?.inflate(R.layout.fragment_type, container, false)
    }

    override fun initDatas() {
    }

    override fun initPresneter() {
        var mPresenter = TypePersenter(this)
        mPresenter.getType()
    }
}