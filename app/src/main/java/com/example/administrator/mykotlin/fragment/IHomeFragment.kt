package com.example.administrator.mykotlin.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.adapter.MyHomeAdapter
import com.example.administrator.mykotlin.base.BaseFragment
import com.example.administrator.mykotlin.iview.IHomeView
import com.example.administrator.mykotlin.persenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import top.jowanxu.wanandroidclient.bean.Datas
import top.jowanxu.wanandroidclient.bean.HomeListResponseBean

/**
 * Created by Administrator on 2018\4\12 0012.
 */
class IHomeFragment : BaseFragment<HomePresenter>(), IHomeView {
    var homeList: HomeListResponseBean? = null
    var datas=ArrayList<Datas>()
    //服务器返回成功的显示
    override fun homeSuccess(result: HomeListResponseBean) {
        homeList=result
        hidden()
        datas.addAll(result.data.datas!!)
//        var recycler01=views?.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager=LinearLayoutManager(activity)
//        recycler.adapter= MyHomeAdapter(context,R.layout.item_home,datas)
        recycler.adapter= MyHomeAdapter(context,R.layout.item_home,datas)
//        Log.e("result",result.toString())
    }

    //服务器返回失败的显示
    override fun homeFaile(meass: String?) {
        Log.e("result", "loginFail")
    }

    override fun initPresneter() {
        mPresenter= HomePresenter(this)
//        refresh.startLayoutAnimation()
    }

    var i=0
    private var views:View?=null
    override fun getMyView(inflater: LayoutInflater?,container:ViewGroup?): View? {
        views?:let{
            views=inflater?.inflate(R.layout.fragment_home,container,false)
        }
        return views
    }

    override fun initDatas() {
       /* for(i in 1..100){
        datas.add("dahei")
        }*/
        mPresenter?.getHome(1)
        show()
        refresh.setEnableRefresh(false)
        refresh.setEnableLoadMore(true)
        refresh.setOnLoadMoreListener {
            mPresenter?.getHome(homeList?.data?.curPage!!)
            refresh.finishLoadMore()
        }
        /* var datas=homeList?.data?.datas
 //        var recycler01=views?.findViewById<RecyclerView>(R.id.recycler)
         recycler.layoutManager=LinearLayoutManager(activity)
         recycler.adapter= MyHomeAdapter(context,R.layout.item_home,datas)*/

        /*recycler.run {
            layoutManager=LinearLayoutManager(activity)
            adapter=MyHomeAdapter(context,R.layout.item_home,datas)
        }*/
    }

}