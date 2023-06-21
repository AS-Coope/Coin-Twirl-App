package com.example.coinflipper

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button = findViewById(R.id.flipBtn)
        flipButton.setOnClickListener {
            flipCoin()
        }
        // show image on first start of app
        val startImage: ImageView = findViewById(R.id.iconIv)
        startImage.setImageResource(R.drawable.coin_heads)
    }

    private fun flipCoin(){
        val coin = Coin()
        val coinResult: TextView = findViewById(R.id.resultTv)
        val imageResult: ImageView = findViewById(R.id.iconIv)

        // storing result of coin flip
        val coinFlipResult = coin.flip()
        // shows relevant icon when heads or tails is shown on coin
        when(coinFlipResult){
            "Heads" -> {
                imageResult.setImageResource(R.drawable.coin_heads)
            } "Tails" -> {
                imageResult.setImageResource(R.drawable.coin_tails)
            }
        }
        // display result message on screen
        coinResult.text = "You got ${coinFlipResult}!"
        imageResult.contentDescription = coinResult.text
    }
}

class Coin {
    fun flip(): String {
        // if statements are also expressions in themselves. As such, they can return an actual
        // value, which is what makes them useful here.
        return if ((1..2).random() == 1) "Heads" else "Tails"
    }
}