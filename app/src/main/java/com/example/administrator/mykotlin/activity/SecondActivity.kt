package com.example.administrator.mykotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.administrator.mykotlin.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView3.text=" this is secondActivity"
        button2.setOnClickListener(onclicklisten)
    }

    private val onclicklisten= View.OnClickListener { View ->
            when (View.id) {
                R.id.button2 -> {
                    var intent = Intent()
                    setResult(0x12)
                    finish()
                }
            }
    }
}
