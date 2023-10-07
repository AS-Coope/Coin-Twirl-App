package com.example.coinflipper

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.coinflipper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: CoinFlipperViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.coinFlipperViewModel = viewModel
        binding.lifecycleOwner = this
        //viewModel.initializeAppData()
        // show image on first start of app
        binding.iconIv.setImageResource(viewModel.coinFlipImage.value!!)
        binding.flipBtn.setOnClickListener {
            flipCoin()
        }
    }

    private fun flipCoin(){
        /*
        //val coin = Coin()
        val coinResult: TextView = findViewById(R.id.resultTv)
        val imageResult: ImageView = findViewById(R.id.iconIv)


         */
        // storing result of coin flip
        //val coinFlipResult = coin.flip()
        // shows relevant icon when heads or tails is shown on coin

        when(viewModel.flip()){

            "Heads" -> {
                //Log.d("MainActivity", "${viewModel.coinFlipTextResult.value}")
                binding.iconIv.setImageResource(viewModel.coinFlipImage.value!!)
            } "Tails" -> {
                //Log.d("MainActivity", "${viewModel.coinFlipTextResult.value}")
                binding.iconIv.setImageResource(viewModel.coinFlipImage.value!!)
            }

        }


        // display result message on screen
        //binding.resultTv.text = "You got ${viewModel.coinFlipTextResult.value}!"
        //binding.iconIv.contentDescription = binding.resultTv.text
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
