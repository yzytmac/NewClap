package com.yzytmac.newclap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.AbsoluteLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val width = this.window.windowManager.defaultDisplay.width
        val height = this.window.windowManager.defaultDisplay.height
        val random = java.util.Random()


        bt.setOnClipListener {
            val imageView = ImageView(this)
            val x = width - (random.nextInt(width - 200) + 200)
            val y = height - (random.nextInt(height - 400) + 400)
            val layoutParams = AbsoluteLayout.LayoutParams(100, 100, x, y)
            imageView.setImageResource(R.drawable.clap)
            imageView.layoutParams = layoutParams
            rl.addView(imageView)
            val translateAnimation = TranslateAnimation(0f, 100 - x.toFloat(), 0f, 100 - y.toFloat())
            translateAnimation.duration = 1000
            imageView.startAnimation(translateAnimation)
            translateAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    imageView.visibility = View.GONE
                    rl.removeView(imageView)
                }

                override fun onAnimationStart(animation: Animation?) {
                }
            })
        }
    }
}
