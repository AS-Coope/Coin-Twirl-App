package com.example.coinflipper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinFlipperViewModel: ViewModel() {

    // mutable live data with their backing properties
    private var _coinFlipTextResult = MutableLiveData<String>("Heads")
    val coinFlipTextResult: LiveData<String>
        get() = _coinFlipTextResult

    private var _coinFlipImage = MutableLiveData<Int>(R.drawable.coin_heads)
    val coinFlipImage: LiveData<Int>
        get() = _coinFlipImage

    // handles what text result and coin image will be shown on screen
    fun flip() {

        if ((1..2).random() == 1) {
            _coinFlipTextResult.value = "Heads"
            _coinFlipImage.value = R.drawable.coin_heads
        } else {
            _coinFlipTextResult.value = "Tails"
            _coinFlipImage.value = R.drawable.coin_tails
        }
    }
}