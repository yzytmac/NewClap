package com.yzytmac.newclap

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.ScaleAnimation
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_clapbt.view.*

/**
 * Created by yzy on 2019-12-03 12:28
 * Email: yzytmac@163.com
 * Phone: 18971165201
 * QQ: 398564331
 * Description:
 */

class ClapButton(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private var progress = 0
    private lateinit var mListener:()->Unit

    init {
        View.inflate(context, R.layout.layout_clapbt, this)
        this.setOnClickListener {
            bar.setProgress(++progress)
            val scaleAnimation = ScaleAnimation(1f, 1.3f, 1f, 1.3f, (iv.width / 2).toFloat(), ((iv.height / 2).toFloat()))
            scaleAnimation.duration=200
            iv.startAnimation(scaleAnimation)
            mListener.invoke()
        }
    }

    fun setOnClipListener(listener:()->Unit){
        mListener = listener
    }
}