package com.example.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    var counter = countReserved

}