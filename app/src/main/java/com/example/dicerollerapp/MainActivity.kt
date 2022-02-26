package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //nullを排除することでコードが簡単になる
    //ここで宣言しておくと、毎回ImageViewがビルドされる必要がなくなる
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ここで宣言
        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        //ボタンが押された際にrollDiceが呼ばれる
        rollButton.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
        //短時間表示するtoastを呼ぶ
        /*Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
         */
        //1から6の数字をランダムに出す
        val randomInt = (1..6).random()

        //randomIntに応じて写真が変化する
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}