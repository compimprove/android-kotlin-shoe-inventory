package com.example.shoestore.screen.shoedetail

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

    fun updateName(s: String) {
        _shoeName.value = s
    }

    fun updateCompany(s: String) {
        _company.value = s
    }

    fun updateDescription(s: String) {
        _description.value = s
    }

    fun updateSize(s: String) {
        _size.value = s.toFloatOrNull() ?: 0.0f
    }
}