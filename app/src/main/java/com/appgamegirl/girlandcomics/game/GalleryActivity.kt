package com.appgamegirl.girlandcomics.game

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.databinding.ActivityGalleryBinding
import com.appgamegirl.girlandcomics.loadData
import com.appgamegirl.girlandcomics.showToast
import android.app.AlertDialog
import android.view.animation.AnimationUtils
import android.widget.ImageView

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    private lateinit var level1: List<Int>
    private lateinit var level2: List<Int>
    private lateinit var level3: List<Int>

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        level1 = listOf(
            R.drawable.card_1,
            R.drawable.card_2,
            R.drawable.card_3,
            R.drawable.card_4,
            R.drawable.card_5,
            R.drawable.card_6
        )
        level2 = listOf(
            R.drawable.card_lvl_2_1,
            R.drawable.card_lvl_2_2,
            R.drawable.card_lvl_2_3,
            R.drawable.card_lvl_2_4,
            R.drawable.card_lvl_2_5,
            R.drawable.card_lvl_2_6
        )

        level3 = listOf(
            R.drawable.card_lvl_3_1,
            R.drawable.card_lvl_3_2,
            R.drawable.card_lvl_3_3,
            R.drawable.card_lvl_3_4,
            R.drawable.card_lvl_3_5,
            R.drawable.card_lvl_3_6
        )

        if (!loadData(1)) {
            binding.imageViewGallery1.setColorFilter(
                getColor(R.color.blur),
                PorterDuff.Mode.MULTIPLY
            )
        }

        if (!loadData(2)) {
            binding.imageViewGallery2.setColorFilter(
                getColor(R.color.blur),
                PorterDuff.Mode.MULTIPLY
            )
        }

        if (!loadData(3)) {
            binding.imageViewGallery3.setColorFilter(
                getColor(R.color.blur),
                PorterDuff.Mode.MULTIPLY
            )
        }

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        with(binding) {
            buttonGallery1.setOnClickListener {
                it.startAnimation(scaleAnimation)
                if (!loadData(1)) {
                    showToast("Before completed Level 1!")
                } else {
                    showGalleryDialog(level1)
                }
            }

            buttonGallery2.setOnClickListener {
                it.startAnimation(scaleAnimation)
                if (!loadData(2)) {
                    showToast("Before completed Level 2!")
                } else {
                    showGalleryDialog(level2)
                }
            }

            buttonGallery3.setOnClickListener {
                it.startAnimation(scaleAnimation)
                if (!loadData(3)) {
                    showToast("Before completed Level 3!")
                } else {
                    showGalleryDialog(level3)
                }
            }

            buttonBackGallery.setOnClickListener {
                finish()
            }
        }

    }

    private fun showGalleryDialog(images: List<Int>) {
        var currentIndex = 0

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.gallery_alert, null)
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create()

        val imageView = dialogView.findViewById<ImageView>(R.id.art)
        val buttonNext = dialogView.findViewById<ImageView>(R.id.imageViewNext)
        val buttonPrev = dialogView.findViewById<ImageView>(R.id.imageViewPrev)

        imageView.setImageResource(images[currentIndex])

        buttonNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            imageView.setImageResource(images[currentIndex])
        }

        buttonPrev.setOnClickListener {
            currentIndex = if (currentIndex - 1 < 0) images.size - 1 else currentIndex - 1
            imageView.setImageResource(images[currentIndex])
        }
        alertDialog.show()
    }
}