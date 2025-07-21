package com.appgamegirl.girlandcomics

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun Activity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.saveData(level: Int, result: Boolean) {
    val sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(level.toString(), result)
    editor.apply()
}

fun Activity.loadData(level: Int): Boolean {
    val sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(level.toString(), false)
}

fun animationsFlip(imageView: ImageView, imageResId: Int) {
    val flipOutAnimation = AnimationUtils.loadAnimation(imageView.context, R.anim.flip_out)

    if (!flipOutAnimation.hasStarted() || flipOutAnimation.hasEnded()) {
        flipOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                imageView.setImageResource(imageResId)
                imageView.clearAnimation()
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })

        if (!flipOutAnimation.hasStarted()) {
            imageView.startAnimation(flipOutAnimation)
        }
    }
}

fun animationsBounce(imageView: ImageView) {
    val bounceAnimation = AnimationUtils.loadAnimation(imageView.context, R.anim.scale)

    if (!bounceAnimation.hasStarted() || bounceAnimation.hasEnded()) {
        bounceAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                imageView.clearAnimation()
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })

        if (!bounceAnimation.hasStarted()) {
            imageView.startAnimation(bounceAnimation)
        }
    }
}

