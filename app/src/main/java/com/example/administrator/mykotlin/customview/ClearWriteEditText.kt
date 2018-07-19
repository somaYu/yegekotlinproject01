package com.example.administrator.mykotlin.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.EditText

import com.example.administrator.mykotlin.R


/**
 * Created by AMing on 15/11/2.
 * Company RongCloud
 */

@SuppressLint("AppCompatCustomView")
class ClearWriteEditText @JvmOverloads constructor(
        context: Context
        , attrs: AttributeSet? = null
        , def: Int = android.R.attr.editTextStyle
) : EditText(context, attrs, def)
        , View.OnFocusChangeListener
        , TextWatcher {

    // 删除按钮
    var drawable: Drawable? = null

    init {
        initView()
    }

    private fun initView() {
        drawable = resources.getDrawable(R.drawable.search_clear_pressed_write)
        drawable!!.setBounds(
                0
                , 0
                , drawable!!.intrinsicWidth
                , drawable!!.intrinsicHeight
        )
        setIvVisible(false)

        // 这个注册监听真让人醉了
        this.onFocusChangeListener = this
        this.addTextChangedListener(this)
    }

    // 意思也是能提到扩展函数里去咯？？？？？？？？？？？？？为何定义成静态方法
    companion object {

        /**
         * @param num 半秒钟晃动多少下
         */
        fun myShakeAnimation(num: Int): Animation {
            val ta = TranslateAnimation(
                    0f
                    , 10f
                    , 0f
                    , 0f)
            ta.interpolator = CycleInterpolator(num.toFloat())
            ta.duration = 500
            return ta
        }
    }

    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件
     * 当我们按下的位置 在  EditText的宽度 - 图标到控件右边的间距 - 图标的宽度  和
     * EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向没有考虑
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            if (event.action == MotionEvent.ACTION_UP) {

                val a = event.x > (width - paddingRight - drawable!!.intrinsicWidth)

                // bc写法等效
                val b = event.x < (width - paddingRight)
//                val c = event.x < width - paddingRight

//                val d =
//                        event.x > (width - paddingRight - drawable!!.intrinsicWidth)
//                        && event.x < width - paddingRight

                val d = a && b

                if (d) {
                    this.setText("")
                }

                Log.e("yy", "呵呵")
            }
        }

        return super.onTouchEvent(event)
    }

    // 设置晃动动画
    fun setShakeAnimation() {
        this.startAnimation(myShakeAnimation(3))
    }

    // 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (hasFocus) {
            setIvVisible(text.length > 0)
        } else {
            setIvVisible(false)
        }
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        setIvVisible(s.length > 0)
    }

    override fun afterTextChanged(s: Editable) {

    }

    protected fun setIvVisible(b: Boolean) {
        val right = if (b) drawable else null

        // 这么写要崩溃
//        var right = null
//
//        if (b) {
//            right = drawable as Nothing?
//        }

        setCompoundDrawables(
                compoundDrawables[0]
                , compoundDrawables[1]
                , right
                , compoundDrawables[3])
    }

}
