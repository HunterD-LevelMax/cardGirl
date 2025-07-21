package com.appgamegirl.girlandcomics.game

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.appgamegirl.girlandcomics.MainActivity
import com.appgamegirl.girlandcomics.R
import com.appgamegirl.girlandcomics.animationsBounce
import com.appgamegirl.girlandcomics.animationsFlip
import com.appgamegirl.girlandcomics.databinding.ActivityCardGameBinding
import com.appgamegirl.girlandcomics.replaceActivity
import com.appgamegirl.girlandcomics.saveData
import com.appgamegirl.girlandcomics.service.MusicService
import com.appgamegirl.girlandcomics.showToast
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CardGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardGameBinding
    private lateinit var cardsView: Array<Array<ImageView>>
    private var enabled = true
    private lateinit var level1: List<Int>
    private lateinit var level2: List<Int>
    private lateinit var level3: List<Int>
    private lateinit var cards: Array<Array<Int>>
    private val shirtDrawable = R.drawable.card
    private var gameTimer: CountDownTimer? = null
    private var currentTimeInSeconds = 0L
    private var cardMusic = MediaPlayer()
    private var count: Int = 0
    private var sound = true

    private var level = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBackCard.setOnClickListener {
            finish()
        }

        cardMusic = MediaPlayer.create(this, R.raw.card)

        binding.buttonMusic.setImageResource(R.drawable.baseline_music_note_24)

        binding.buttonMusic.setOnClickListener {
            sound = !sound

            if (sound) {
                binding.buttonMusic.setImageResource(R.drawable.baseline_music_note_24)
                startService(Intent(this, MusicService::class.java))
            } else {
                binding.buttonMusic.setImageResource(R.drawable.baseline_music_off_24)
                stopService(Intent(this, MusicService::class.java))
            }
        }

        cardInit()
        initGame()

    }

    private fun soundCard(onSound: Boolean, mediaPlayer: MediaPlayer) {
        try {
            if (onSound) {
                mediaPlayer.start()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun startGameTimer() {
        gameTimer?.cancel()

        gameTimer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentTimeInSeconds++
                updateTimerText()
            }

            override fun onFinish() {}
        }
        gameTimer?.start()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTimerText() {
        val minutes = currentTimeInSeconds / 60
        val seconds = currentTimeInSeconds % 60
        val timerText = String.format("%02d:%02d", minutes, seconds)
        binding.timeTextView.text = "${getString(R.string.time)} $timerText"
    }

    private fun stopGameTimer() {
        gameTimer?.cancel()
    }

    private fun resetGame() {
        stopGameTimer()
        currentTimeInSeconds = 0
        count = 0
        updateTimerText()
        initGame()
        resetCard()
    }

    private fun initGame() {
        binding.buttonLvl.text = "Level $level"
        startGameTimer()

        when (level) {
            1 -> {
                shuffle(level1)
            }

            2 -> {
                shuffle(level2)
            }

            3 -> {
                shuffle(level3)
            }

            else -> level = 1
        }
    }

    private fun shuffle(level: List<Int>) {
        val shuffledLevel = level.shuffled()

        cards = Array(4) { row ->
            Array(3) { col ->
                val index = row * 3 + col
                shuffledLevel[index]
            }
        }

        cardsView.forEachIndexed { row, rowArray ->
            rowArray.forEachIndexed { col, imageView ->
                imageView.isClickable = true
                animationsFlip(imageView, shirtDrawable)
                imageView.setOnClickListener {
                    onCardClicked(imageView, row, col)
                    soundCard(sound, cardMusic)
                }
            }
        }
    }

    private fun cardInit() {
        binding.apply {
            cardsView = arrayOf(
                arrayOf(cell11, cell12, cell13),
                arrayOf(cell21, cell22, cell23),
                arrayOf(cell31, cell32, cell33),
                arrayOf(cell41, cell42, cell43)
            )
        }

        level1 = listOf(
            R.drawable.card_1,
            R.drawable.card_1,
            R.drawable.card_2,
            R.drawable.card_2,
            R.drawable.card_3,
            R.drawable.card_3,
            R.drawable.card_4,
            R.drawable.card_4,
            R.drawable.card_5,
            R.drawable.card_5,
            R.drawable.card_6,
            R.drawable.card_6
        )

        level2 = listOf(
            R.drawable.card_lvl_2_1,
            R.drawable.card_lvl_2_1,
            R.drawable.card_lvl_2_2,
            R.drawable.card_lvl_2_2,
            R.drawable.card_lvl_2_3,
            R.drawable.card_lvl_2_3,
            R.drawable.card_lvl_2_4,
            R.drawable.card_lvl_2_4,
            R.drawable.card_lvl_2_5,
            R.drawable.card_lvl_2_5,
            R.drawable.card_lvl_2_6,
            R.drawable.card_lvl_2_6
        )

        level3 = listOf(
            R.drawable.card_lvl_3_1,
            R.drawable.card_lvl_3_1,
            R.drawable.card_lvl_3_2,
            R.drawable.card_lvl_3_2,
            R.drawable.card_lvl_3_3,
            R.drawable.card_lvl_3_3,
            R.drawable.card_lvl_3_4,
            R.drawable.card_lvl_3_4,
            R.drawable.card_lvl_3_5,
            R.drawable.card_lvl_3_5,
            R.drawable.card_lvl_3_6,
            R.drawable.card_lvl_3_6
        )
    }

    private var firstCard: Int = 0
    private var secondCard: Int = 0
    private var firstIndex: List<Int> = emptyList()
    private var secondIndex: List<Int> = emptyList()

    private fun onCardClicked(imageView: ImageView, row: Int, col: Int) {
        if (enabled) {
            if (firstCard == 0 && (firstIndex.isEmpty() || (firstIndex[0] != row || firstIndex[1] != col))) {
                firstCard = cards[row][col]
                firstIndex = listOf(row, col)
                animationsFlip(imageView, cards[row][col])
            } else if (secondCard == 0 && (secondIndex.isEmpty() || (secondIndex[0] != row || secondIndex[1] != col))) {
                secondCard = cards[row][col]
                secondIndex = listOf(row, col)
                animationsFlip(imageView, cards[row][col])
                matched()
            }
        }
    }

    private fun matched() {
        try {
            if (firstCard == secondCard) {
                correctMatch()
            } else {
                failedMatch()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun correctMatch() {
        GlobalScope.launch(Dispatchers.Main) {
            cardsView[firstIndex[0]][firstIndex[1]].isClickable = false
            cardsView[secondIndex[0]][secondIndex[1]].isClickable = false
            delay(900)
            animationsBounce(cardsView[firstIndex[0]][firstIndex[1]])
            animationsBounce(cardsView[secondIndex[0]][secondIndex[1]])
            resetCard()
            count++
            if (count == 6) {
                win()
            }
        }
    }

    private fun win() {
        showToast(getString(R.string.game_end))
        showAlertDialog()
        initGame()

        saveData(level, true)

        // resetGame()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun failedMatch() {
        enabled = false
        GlobalScope.launch(Dispatchers.Main) {
            delay(900)
            animationsFlip(cardsView[firstIndex[0]][firstIndex[1]], R.drawable.card)
            animationsFlip(cardsView[secondIndex[0]][secondIndex[1]], R.drawable.card)
            resetCard()
        }
    }

    private fun resetCard() {
        firstCard = 0
        secondCard = 0
        firstIndex = emptyList()
        secondIndex = emptyList()
        enabled = true
    }

    override fun onDestroy() {
        super.onDestroy()
        cardMusic.release()
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val alertView: View = layoutInflater.inflate(R.layout.alert_dialog, null)

        builder.setView(alertView)
        val dialog = builder.create()

        val buttonRestart = alertView.findViewById<Button>(R.id.buttonRestart)
        val buttonMainPage = alertView.findViewById<Button>(R.id.buttonMainPage)
        val buttonLvl = alertView.findViewById<Button>(R.id.buttonLvl)

        buttonRestart.setOnClickListener {
            resetGame()
            dialog.dismiss()
        }

        buttonLvl.setOnClickListener {
            level++

            if (level == 4) {
                level = 1
            }

            resetGame()
            dialog.dismiss()
        }

        buttonMainPage.setOnClickListener {
            replaceActivity(MainActivity())
        }
        dialog.show()
    }


    private fun soundOn() {
        try {
            if (sound) {
                startService(Intent(this, MusicService::class.java))
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        soundOn()
    }

    override fun onPause() {
        super.onPause()
        stopService(Intent(this, MusicService::class.java))
    }
}