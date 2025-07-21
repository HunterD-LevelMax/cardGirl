package com.appgamegirl.girlandcomics.comics

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityComicsSecretBinding


class ComicsSecretActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicsSecretBinding
    private var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsSecretBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            buttonMenuSecret.setOnClickListener {
                finish()
            }

            buttonHomeSecret.setOnClickListener {
                finish()
            }

            buttonNextSecret.setOnClickListener {
                count++
                if (count <= 15) {
                    setComics()
                }
            }

            buttonBackSecret.setOnClickListener {
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
                    avatarSecret.visibility = View.INVISIBLE
                    backSecret.background = getDrawable(R.drawable.bg_secret)
                    textSecret.text = getString(R.string.secret_1)
                    buttonBackSecret.visibility = View.INVISIBLE
                    buttonNextSecret.visibility=View.VISIBLE
                }

                2 -> {
                    backSecret.background = getDrawable(R.drawable.bg_secret)
                    textSecret.text = getString(R.string.secret_2)
                    buttonBackSecret.visibility = View.VISIBLE
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.girl_secret)
                    buttonBackSecret.visibility = View.VISIBLE
                }

                3 -> {
                    backSecret.background = getDrawable(R.drawable.bg_watch_secret)
                    textSecret.text = getString(R.string.secret_3)
                    avatarSecret.visibility = View.INVISIBLE
                }

                4 -> {
                    backSecret.background = getDrawable(R.drawable.bg_castle_secret)
                    textSecret.text = getString(R.string.secret_4)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.girl_secret)
                }

                5 -> {
                    backSecret.background = getDrawable(R.drawable.bg_castle_secret)
                    textSecret.text = getString(R.string.secret_5)
                    avatarSecret.visibility = View.INVISIBLE
                }

                6 -> {
                    backSecret.background = getDrawable(R.drawable.bg_castle_secret)
                    textSecret.text = getString(R.string.secret_6)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.man_secret)
                }

                7 -> {
                    backSecret.background = getDrawable(R.drawable.bg_street_secret)
                    textSecret.text = getString(R.string.secret_7)
                    avatarSecret.visibility = View.INVISIBLE
                }

                8 -> {
                    textSecret.text = getString(R.string.secret_8)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.girl_secret)
                }

                9 -> {
                    textSecret.text = getString(R.string.secret_9)
                    avatarSecret.setImageResource(R.drawable.man_secret)
                }

                10 -> {
                    textSecret.text = getString(R.string.secret_10)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.girl_secret)
                    backSecret.background = getDrawable(R.drawable.bg_street_secret)
                }

                11 -> {
                    textSecret.text = getString(R.string.secret_11)
                    backSecret.background = getDrawable(R.drawable.bg_dance_secret)
                    avatarSecret.visibility = View.INVISIBLE
                }

                12 -> {
                    textSecret.text = getString(R.string.secret_12)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.man_secret)
                }

                13 -> {
                    textSecret.text = getString(R.string.secret_13)
                    avatarSecret.visibility = View.VISIBLE
                    avatarSecret.setImageResource(R.drawable.girl_secret)
                }

                14 -> {
                    textSecret.text = getString(R.string.secret_14)
                    avatarSecret.visibility = View.INVISIBLE
                    buttonMenuSecret.visibility= View.GONE
                    buttonNextSecret.visibility= View.VISIBLE
                }

                15 -> {
                    avatarSecret.visibility = View.INVISIBLE
                    textSecret.text = getString(R.string.secret_15)
                    buttonMenuSecret.visibility= View.VISIBLE
                    buttonBackSecret.visibility= View.VISIBLE
                    buttonNextSecret.visibility= View.INVISIBLE
                }
            }
        }
    }
}