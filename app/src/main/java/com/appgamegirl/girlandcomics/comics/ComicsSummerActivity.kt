package com.appgamegirl.girlandcomics.comics

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityComicsSummerBinding

class ComicsSummerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicsSummerBinding
    private var count = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsSummerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            buttonMenuSummer.setOnClickListener {
                finish()
            }

            buttonHomeSummer.setOnClickListener {
                finish()
            }

            buttonNextSummer.setOnClickListener {
                count++
                if (count <= 12) {
                    setComics()
                }
            }

            buttonBackSummer.setOnClickListener {
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
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_1)
                    summerAvatar.visibility = View.INVISIBLE
                    buttonBackSummer.visibility = View.INVISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                2 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_2)
                    summerAvatar.visibility = View.VISIBLE
                    buttonBackSummer.visibility = View.VISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                    summerAvatar.setImageResource(R.drawable.girl_summer)
                }

                3 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_3)
                    summerAvatar.visibility = View.INVISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                4 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_4)
                    summerAvatar.setImageResource(R.drawable.man_summer)
                    summerAvatar.visibility = View.VISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                5 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_5)
                    summerAvatar.visibility = View.INVISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                6 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_6)
                    summerAvatar.visibility = View.VISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                    summerAvatar.setImageResource(R.drawable.man_summer)
                }

                7 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_7)
                    summerAvatar.setImageResource(R.drawable.girl_summer)
                    summerAvatar.visibility = View.VISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                8 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_8)
                    summerAvatar.visibility = View.INVISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                9 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_9)
                    summerAvatar.setImageResource(R.drawable.man_summer)
                    summerAvatar.visibility = View.VISIBLE
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                }

                10 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_10)
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                    summerAvatar.setImageResource(R.drawable.man_summer)
                }

                11 -> {
                    backSummer.background = getDrawable(R.drawable.summer_bg)
                    textSummer.text = getString(R.string.summer_11)
                    buttonMenuSummer.visibility = View.GONE
                    buttonNextSummer.visibility = View.VISIBLE
                    summerAvatar.setImageResource(R.drawable.girl_summer)
                    summerAvatar.visibility = View.VISIBLE
                }

                12 -> {
                    backSummer.background = getDrawable(R.drawable.summer_fire)
                    textSummer.text = getString(R.string.summer_12)
                    summerAvatar.visibility = View.INVISIBLE
                    buttonMenuSummer.visibility = View.VISIBLE
                    buttonNextSummer.visibility = View.INVISIBLE
                }
            }
        }
    }
}