package com.example.administrator.mykotlin.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.TypeAdapter
import com.example.administrator.mykotlin.base.BaseFragment
import com.example.administrator.mykotlin.iview.ITypeView
import com.example.administrator.mykotlin.persenter.TypePersenter
import kotlinx.android.synthetic.main.fragment_type.*
import top.jowanxu.wanandroidclient.bean.TreeListResponseBean

/**
 * Created by Administrator on 2018\4\13 0013.
 */
class ITypeFragment : BaseFragment<TypePersenter>(), ITypeView {
    override fun typeSucces(result: TreeListResponseBean) {
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