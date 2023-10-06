package com.example.coinflipper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinFlipperViewModel: ViewModel() {

    private var _coinFlipTextResult = MutableLiveData<String>()
    private var checkIfFirstFlip: Int = 0
    //private var _image = MutableLiveData<ImageView>()
    val coinFlipTextResult: LiveData<String>
            get() = _coinFlipTextResult
    init{
    }
    fun flip(): String{
        Log.d("CoinFlipperViewModel", "Mutable: ${_coinFlipTextResult.value}, Immutable: ${coinFlipTextResult.value}")
        if (checkIfFirstFlip == 0){
            _coinFlipTextResult.value = "Heads"
            checkIfFirstFlip = 1
        } else {
            _coinFlipTextResult.value = if ((1..2).random() == 1) "Heads" else "Tails"
        }
        return coinFlipTextResult.value!!
    }

    fun initializeAppData(){
        _coinFlipTextResult.value = "Heads"
    }
}