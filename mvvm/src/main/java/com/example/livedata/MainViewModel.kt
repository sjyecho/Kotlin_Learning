package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    /**
     * MutableLiveData是一种可变的LiveData,指定它的泛型为Int
     * 主要有三种读写数据的方法，分别是getValue()、setValue()和postValue()方法
     * postValue()用于在非主线程中给LiveData设置数据
     * setValue()用于在主线程中设置数据
     */
    val counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }

    fun clear() {
        counter.value = 0
    }
}