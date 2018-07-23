package com.example.administrator.mykotlin.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.MyHomeAdapter
import com.example.administrator.mykotlin.base.BaseFragment
import com.example.administrator.mykotlin.bean.Datas
import com.example.administrator.mykotlin.bean.HomeListResponseBean
import com.example.administrator.mykotlin.iview.IHomeView
import com.example.administrator.mykotlin.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/23 15:29
 */

class HomeFragment : BaseFragment<HomePresenter>(), IHomeView {

    var views: View? = null
    var i = 0
    var list = ArrayList<Datas>()
    var bean: HomeListResponseBean? = null

    override fun initMyFragmentView(inflater: LayoutInflater, container: ViewGroup?): View? {

        views ?: let {

            views = inflater.inflate(R.layout.fragment_home, container, false)

        }

        return views

    }

    override fun initMyPresenter() {

        mPresenter = HomePresenter(this)

    }

    override fun initMyDatas() {

        mPresenter?.getHome(1)

        myShow()

        // 呵呵呵直接找到下拉刷新控件
        refresh.setEnableRefresh(false)
        refresh.setEnableLoadMore(true)
        refresh.setOnLoadMoreListener {

            mPresenter?.getHome(bean?.data?.curPage!!)
            refresh.finishLoadMore()
        }

    }

    override fun homeSuccess(result: HomeListResponseBean) {

        bean = result
        myHide()
        list.addAll(result.data.datas!!)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = MyHomeAdapter(context, R.layout.item_home, list)


    }

    override fun homeFail(s: String) {
        Log.e("yy", "loginFail")
    }

}

