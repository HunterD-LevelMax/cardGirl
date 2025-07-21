package com.appgamegirl.girlandcomics.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityCardLoaderBinding
import com.appgamegirl.girlandcomics.replaceActivity

class CardLoaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardLoaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardLoaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        with(binding) {

            backCard.setOnClickListener {
                finish()
            }

            buttonPlayCard.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(CardGameActivity())
            }

            buttonClickerGame.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(GalleryActivity())
            }

        }
    }
}