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
class HomeFragment : BaseFragment<HomePresenter>(), IHomeView {

    private var views: View? = null
    var i = 0
    var list = ArrayList<Datas>()
    var bean: HomeListResponseBean? = null

    override fun initMyFragmentView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        views ?: let {
            views = inflater?.inflate(R.layout.fragment_home, container, false)
        }
        return views
    }

    override fun initMyPresneter() {
        mPresenter = HomePresenter(this)
//        refresh.startLayoutAnimation()
    }

    override fun initMyDatas() {
        /* for(i in 1..100){
         list.add("dahei")
         }*/
        mPresenter?.getHome(1)
        myShow()

        // 呵呵呵直接找到下拉刷新控件
        refresh.setEnableRefresh(false)
        refresh.setEnableLoadMore(true)
        refresh.setOnLoadMoreListener {
            mPresenter?.getHome(bean?.data?.curPage!!)
            refresh.finishLoadMore()
        }
        /* var list=bean?.data?.list
 //        var recycler01=views?.findViewById<RecyclerView>(R.id.recycler)
         recycler.layoutManager=LinearLayoutManager(activity)
         recycler.adapter= MyHomeAdapter(context,R.layout.item_home,list)*/

        /*recycler.run {
            layoutManager=LinearLayoutManager(activity)
            adapter=MyHomeAdapter(context,R.layout.item_home,list)
        }*/
    }

    //服务器返回成功的显示
    override fun homeSuccess(result: HomeListResponseBean) {
        bean = result
        myHide()
        list.addAll(result.data.datas!!)
//        var recycler01=views?.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(activity)
//        recycler.adapter= MyHomeAdapter(context,R.layout.item_home,list)
        recycler.adapter = MyHomeAdapter(context, R.layout.item_home, list)
//        Log.e("result",result.toString())
    }

    //服务器返回失败的显示
    override fun homeFail(s: String?) {
        Log.e("yy", "loginFail")
    }

}