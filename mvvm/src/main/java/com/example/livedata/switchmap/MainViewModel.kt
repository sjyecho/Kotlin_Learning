package com.example.livedata.switchmap

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * 当外部掉用MainViewModel的getUser()方法来获取用户数据时,并不会发起任何请求或者函数调用
 * 只会将传入的userId值设置到userIdLiveData当中
 * 一旦userIdLiveData的数据发生变化，那么观察userIdLiveData的switchMap()方法就会执行，并且调用转换函数
 * 转换函数调用Repository.getUser()方法获取真正的用户数据
 * 同时，switchMap()方法会将Repository.getUser()方法返回的LiveData对象转换成一个可观察的LiveData对象
 * 对于Activity而言，只要去观察这个LiveData对象就可以了
 */
class MainViewModel(countReserved: Int) : ViewModel() {

    private val userIdLiveData = MutableLiveData<String>()

    /**
     * switchMap()的工作原理就是要将转换函数中返回的LiveData对象转换成另一个可观察的LiveData对象
     */
    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) { userId ->
        Repository.getUser(userId)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
        Log.d("sjy", "MainViewModel.getUser userId: $userId")
    }

}