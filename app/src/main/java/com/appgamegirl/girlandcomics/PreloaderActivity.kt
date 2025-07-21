package com.appgamegirl.girlandcomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class PreloaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preloader)
        Handler(Looper.getMainLooper()).postDelayed({
            replaceActivity(MainActivity())
            this.finish()
        }, 1000)
    }
}