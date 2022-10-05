package com.tworoot2.jetpackcomponents.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val counter: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(counter) as T
    }

    override fun toString(): String {
        return "MainViewModelFactory(counter=$counter)"
    }
}