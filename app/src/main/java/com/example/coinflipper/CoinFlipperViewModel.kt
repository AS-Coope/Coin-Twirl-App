package com.example.coinflipper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinFlipperViewModel: ViewModel() {

    private var _coinFlipTextResult = MutableLiveData<String>()
    private val coinFlipTextResult: LiveData<String>
            get() = _coinFlipTextResult

    fun flip(): String{
        _coinFlipTextResult.value = if ((1..2).random() == 1) "Heads" else "Tails"
        return coinFlipTextResult.value!!
    }
}