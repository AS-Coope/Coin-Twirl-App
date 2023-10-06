package com.example.coinflipper

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: CoinFlipperViewModel by viewModels()

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

    /*
    Have a function that will take the result of the coin flip calculated
    by the view model, then use that to determine how which image resource
    to show on screen

    There will not need to be a reference to the text view for the coin result.
    Data binding will allow the layout file and the view model to communicate
    where that is concerned

    Move coin flip class to the view model as well
    Actually, I don't think a coin class will even be needed
    Just have the flip function alone and store the result in a variable
    which will make use of the backing property to send it back to the
    UI Controller (Main Activity)

    Ensure the result of the coin flip is stored in a variable. That is what
    data binding will use in the layout file
     */
}

class Coin {
    fun flip(): String {
        // if statements are also expressions in themselves. As such, they can return an actual
        // value, which is what makes them useful here.
        return if ((1..2).random() == 1) "Heads" else "Tails"
    }
}
