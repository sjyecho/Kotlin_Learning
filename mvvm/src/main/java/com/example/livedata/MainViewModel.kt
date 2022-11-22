package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    /**
     * MutableLiveData是一种可变的LiveData,指定它的泛型为Int
     * 主要有三种读写数据的方法，分别是getValue()、setValue()和postValue()方法
     * postValue()用于在非主线程中给LiveData设置数据
     * setValue()用于在主线程中设置数据
     */
    //val counter = MutableLiveData<Int>()
    //如上，counter这个可变的LiveData暴露给了外部。即使是在ViewModel外也是可以给counter设置数据，从而破坏了ViewModel数据的封装性

    // 不可变的LiveData
    val counter: LiveData<Int>
        get() = _counter //重写LiveData的getter方法，setter方法无法被覆盖，因为val类型

    private val _counter = MutableLiveData<Int>()

    init {
        //counter.value = countReserved
        _counter.value = countReserved
    }

    fun plusOne() {
//        val count = counter.value ?: 0
//        counter.value = count + 1
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
//        counter.value = 0
        _counter.value = 0
    }
}