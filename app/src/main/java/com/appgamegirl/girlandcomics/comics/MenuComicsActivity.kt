package com.appgamegirl.girlandcomics.comics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityMenuComicsBinding
import com.appgamegirl.girlandcomics.replaceActivity

class MenuComicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuComicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        with(binding) {

            buttonBackComics.setOnClickListener {
                finish()
            }

            buttonReadSummer.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(ComicsSummerActivity())
            }
            buttonReadHeart.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(ComicsHeartActivity())
            }
            buttonReadSecret.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(ComicsSecretActivity())
            }
        }
    }
}