package com.example.shoestore.screen.shoedetail

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private var _shoeName = MutableLiveData("")
    val shoeName: LiveData<String>
        get() = _shoeName
    private var _size = MutableLiveData(0.0f)
    val shoeSize: LiveData<Float>
        get() = _size
    private var _company = MutableLiveData("")
    val shoeCompany: LiveData<String>
        get() = _company
    private var _description = MutableLiveData("")
    val shoeDescription: LiveData<String>
        get() = _description

    fun updateName(e: Editable) {
        _shoeName.value = e.toString()
    }

    fun updateCompany(e: Editable) {
        _company.value = e.toString()
    }

    fun updateDescription(e: Editable) {
        _description.value = e.toString()
    }

    fun updateSize(e: Editable) {
        _size.value = e.toString().toFloatOrNull()
    }
}