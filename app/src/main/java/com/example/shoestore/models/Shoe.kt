package com.example.shoestore.models

data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) {
    constructor() : this("", 0.0, "", "")

    fun getSizeShoe(): String {
        return size.toString()
    }

    fun setSizeShoe(s: String) {
        val sizeShoe = s.toDoubleOrNull() ?: 0.0
        if (size != sizeShoe) {
            size = sizeShoe
        }
    }
}