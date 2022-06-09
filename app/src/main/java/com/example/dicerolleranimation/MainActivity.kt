package com.example.dicerolleranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import java.util.Collections.rotate

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var tvSum: TextView
    val random: Random = Random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        tvSum = findViewById(R.id.tvSum)

        var sum = 1;
        diceImage.setOnClickListener {
//            rotateDice()
            object : CountDownTimer(1000, 100) {
                override fun onFinish() {
                    sum = rotateDice()
                    tvSum.text = sum.toString()
                }

                override fun onTick(p0: Long) {
                    sum = rotateDice()
                    tvSum.text = sum.toString()
                }
            }.start()
        }
    }

    private fun rotateDice(): Int {
        val i: Int = random.nextInt(5) + 1
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        diceImage.startAnimation(anim)
        val drawableResource = when (i) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        diceImage.setImageResource(drawableResource)
        return i;
    }
}