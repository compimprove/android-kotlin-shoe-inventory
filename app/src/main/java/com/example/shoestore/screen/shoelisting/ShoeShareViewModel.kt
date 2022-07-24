package com.example.shoestore.screen.shoelisting

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe
import kotlin.math.log

class ShoeShareViewModel : ViewModel() {
    private var _shoes = MutableLiveData<List<Shoe>>();

    init {
        Log.i("ShoeShareViewModel", "init")
        _shoes.value = listOf(
            Shoe("Shoe1", 1.0, "Company1", "Description1"),
            Shoe("Shoe2", 2.0, "Company2", "Description2"),
            Shoe("Shoe3", 3.0, "Company3", "Description3"),
            Shoe("Shoe4", 4.0, "Company4", "Description4"),
            Shoe("Shoe5", 5.0, "Company5", "Description5"),
            Shoe("Shoe6", 6.0, "Company6", "Description6"),
            Shoe("Shoe7", 7.0, "Company7", "Description7"),
            Shoe("Shoe8", 8.0, "Company8", "Description8"),
            Shoe("Shoe9", 9.0, "Company9", "Description9"),
        )
    }

    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    fun addShoe(shoe: Shoe) {
        _shoes.value = _shoes.value?.plus(shoe)
    }

    override fun onCleared() {
        Log.i("ShoeShareViewModel", "onCleared")
        super.onCleared()
    }
}