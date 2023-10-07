package com.example.coinflipper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinFlipperViewModel: ViewModel() {

    private var _coinFlipTextResult = MutableLiveData<String>("Heads")
    //private var checkIfFirstFlip: Int = 0
    val coinFlipTextResult: LiveData<String>
        get() = _coinFlipTextResult

    private var _coinFlipImage = MutableLiveData<Int>(R.drawable.coin_heads)
    val coinFlipImage: LiveData<Int>
        get() = _coinFlipImage

    init{
    }
    fun flip(): String{
        Log.d("CoinFlipperViewModel", "Mutable: ${_coinFlipTextResult.value}, Immutable: ${coinFlipTextResult.value}")

        if ((1..2).random() == 1) {
            _coinFlipTextResult.value = "Heads"
            _coinFlipImage.value = R.drawable.coin_heads
        } else {
            _coinFlipTextResult.value = "Tails"
            _coinFlipImage.value = R.drawable.coin_tails
        }
        return coinFlipTextResult.value!!
    }

    fun initializeAppData(){
        _coinFlipTextResult.value = "Heads"
    }
}