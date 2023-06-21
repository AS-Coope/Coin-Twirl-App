package com.example.coinflipper

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button = findViewById(R.id.button)
        flipButton.setOnClickListener {
            flipCoin()
        }
    }

    private fun flipCoin(){
        val coin = Coin()
        val resultView: TextView = findViewById(R.id.textView)

        resultView.text = coin.flip()
    }
}

class Coin {
    fun flip(): String {
        // if statements are also expressions in themselves. As such, they can return an actual
        // value, which is what makes them useful here.
        return if ((1..2).random() == 1) "Heads" else "Tails"
    }
}
