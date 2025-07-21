package com.appgamegirl.girlandcomics

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.appgamegirl.girlandcomics.comics.MenuComicsActivity
import com.appgamegirl.girlandcomics.databinding.ActivityMainBinding
import com.appgamegirl.girlandcomics.game.CardLoaderActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        with(binding) {
            buttonGame.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(CardLoaderActivity())
            }

            buttonComics.setOnClickListener {
                it.startAnimation(scaleAnimation)
                replaceActivity(MenuComicsActivity())
            }

            buttonPrivacy.setOnClickListener {
                it.startAnimation(scaleAnimation)
                val url = getString(R.string.url_privacy)

                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(this@MainActivity, Uri.parse(url))
            }
        }
    }






}
