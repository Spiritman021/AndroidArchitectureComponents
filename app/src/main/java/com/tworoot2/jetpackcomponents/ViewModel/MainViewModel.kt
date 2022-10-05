package com.tworoot2.jetpackcomponents.ViewModel

import androidx.lifecycle.ViewModel

class MainViewModel(private val initialVal: Int): ViewModel() {
    var count = initialVal

    fun increment(){
        count++
    }

}