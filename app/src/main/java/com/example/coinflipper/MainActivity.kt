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
        binding.lifecycleOwner = this // important line: LiveData will not be observed by this
                                      // UI controller if this is not stated
        binding.iconIv.setImageResource(viewModel.coinFlipImage.value!!)
    }

    override fun onResume() {
        super.onResume()
        binding.flipBtn.setOnClickListener {
            flipCoin()
        }
    }

    private fun flipCoin(){
        viewModel.flip()
        binding.iconIv.setImageResource(viewModel.coinFlipImage.value!!)
    }
}
