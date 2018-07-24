package com.example.administrator.mykotlin.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.EditText
import com.example.administrator.mykotlin.R

/**
 * @author wodemingziyouyidianchang
 * @version 1.0.0
 * @since 2018/7/19 10:22
 */

// @JvmOverloads这注释长见识了
// 不实现方法也不报错的？长见识了
class MyClearEditText @JvmOverloads constructor(

        context: Context
        , attrs: AttributeSet
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

    // kotlin伴生对象
    // 还提供了个莫名其妙的静态方法
    // 返回值是Animation
    companion object {

        fun myShakeAnimation(num: Int): Animation {

            val ta = TranslateAnimation(
                    0f
                    , 10f
                    , 0f
                    , 0f
            )

            ta.interpolator = CycleInterpolator(num.toFloat())
            ta.duration = 500

            return ta

        }

    }

    // 暂时没看出来有啥用
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//
//        if (compoundDrawables[2] != null) {
//
//            if (event.action == MotionEvent.ACTION_UP) {
//
//                val a = event.x < (width - paddingRight - drawable!!.intrinsicWidth)
//                val b = event.x < (width - paddingRight)
//
//                val d = a && b
//
//                if (d) {
//                    setText("")
//                }
//
//                Log.e("yy", "ClearWriteEditText呵呵");
//
//            }
//
//        }
//
//        return super.onTouchEvent(event)
//    }

    fun setShakeAnimation() {
        startAnimation(myShakeAnimation(3))
    }

    // 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
    override fun onFocusChange(v: View?, hasFocus: Boolean) {

        if (hasFocus) {
            // 这个text也真是见了鬼了，哪就冒出来这么一个
            setIvVisible(text.length > 0)
        } else {
            setIvVisible(false)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, lengthBefore: Int, lengthAfter: Int) {
//        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        setIvVisible(s.length > 0)
    }

    override fun afterTextChanged(s: Editable?) {
    }

    fun setIvVisible(b: Boolean) {

        val right = if (b) drawable else null

        // 这种写法导致崩溃
//        var right = null
//
//        if (b) {
//            right = drawable as Nothing?
//        }

        setCompoundDrawables(
                compoundDrawables[0]
                , compoundDrawables[1]
                , right
                , compoundDrawables[3]
        )

    }

}