package com.appgamegirl.girlandcomics.comics

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityComicsHeartBinding

class ComicsHeartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsHeartBinding
    private var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsHeartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            buttonMenuHeart.setOnClickListener {
                finish()
            }

            buttonHomeHeart.setOnClickListener {
                finish()
            }

            buttonNextHeart.setOnClickListener {
                count++
                if (count <= 10) {
                    setComics()
                }
            }

            buttonBackHeart.setOnClickListener {
                count--
                setComics()
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setComics() {
        with(binding) {
            when (count) {
                1 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_1)
                    buttonBackHeart.visibility = View.INVISIBLE
                    buttonNextHeart.visibility = View.VISIBLE
                    buttonMenuHeart.visibility = View.INVISIBLE
                    heartAvatar.visibility = View.INVISIBLE
                }

                2 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_2)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.VISIBLE
                    heartAvatar.setImageResource(R.drawable.girl_heart)
                    buttonBackHeart.visibility = View.VISIBLE
                }

                3 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_3)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.INVISIBLE
                }

                4 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_4)
                    buttonNextHeart.visibility = View.VISIBLE
                }

                5 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_5)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.VISIBLE
                }

                6 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_6)
                    heartAvatar.setImageResource(R.drawable.man_heart)
                    buttonNextHeart.visibility = View.VISIBLE
                }

                7 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_7)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.INVISIBLE
                }

                8 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_8)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.VISIBLE
                    heartAvatar.setImageResource(R.drawable.man_heart)
                }

                9 -> {
                    backHeart.background = getDrawable(R.drawable.bg_heart)
                    textHeart.text = getString(R.string.heart_9)
                    buttonNextHeart.visibility = View.VISIBLE
                    heartAvatar.setImageResource(R.drawable.girl_heart)
                    heartAvatar.visibility = View.VISIBLE
                    buttonMenuHeart.visibility = View.INVISIBLE
                }

                10 -> {
                    backHeart.background = getDrawable(R.drawable.bg_final_heart)
                    textHeart.text = getString(R.string.heart_10)
                    buttonBackHeart.visibility = View.VISIBLE
                    buttonNextHeart.visibility = View.INVISIBLE
                    buttonMenuHeart.visibility = View.VISIBLE
                    heartAvatar.visibility = View.INVISIBLE
                }
            }
        }
    }
}