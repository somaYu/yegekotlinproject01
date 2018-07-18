package com.example.administrator.mykotlin.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.administrator.mykotlin.R
import com.example.administrator.mykotlin.bean.Car
import com.example.administrator.mykotlin.bean.Person
import com.example.administrator.mykotlin.extend.myToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setText("text01")
        textView2.setText("text02")
//        test()

        /*
        kotlin中扩展函数的
        使用
         */
//        textView2.myInvisible()

        /*
        kotlin的点击事件的写法
         */
        button.setOnClickListener(onclicklisten)

        /*
        数据类的使用
         */
        var person= Person("dahei", 1)
        //修改数据类
        var person02=person.copy(name = "laoda")
        textView.text=person.name
        textView2.text=person02.name

        /*
        普通类的构造
        普通类没有copy的方法
         */
        var car= Car()
        car.name="dazhong"
        textView.text=car.name
        //普通类的修改
        car.name="xiandai"
        textView2.text=car.name
    }

    /*
    类似于java中的lamb表达式的写法
     */
        private val onclicklisten=View.OnClickListener {View->
            when(View.id){
              R.id.button ->{
                  myToast("点击")
//                  startActivity(Intent(this,SecondActivity::class.java))
//                  startActivityForResult(Intent(this,SecondActivity::class.java),0x11)
                  test()
              }
            }
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==0x12){
            myToast("回调成功")
        }
    }

    /*
    kotlin中协程的使用
    类似于线程
    但是它是线程之上的
    通过调度来实现
     */
    fun test(){
        //谁调用就在谁的协程里调用这个
        var job1=launch (Unconfined,CoroutineStart.LAZY){
            var i=0
            while (true){
//                Thread.sleep(500)
                delay(500)
                i++
                println("i的值是::$i")
            }
        }
        //异步开启一个协程
        var job2=async(CommonPool) {
            job1.start()
           println( "dahei")
        }
        //在ui协程中调用这个
        async(UI) {
            delay(3000)
            job1.cancel()
            println(job2.await())
        }
    }
}
