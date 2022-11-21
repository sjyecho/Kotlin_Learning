package com.example.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.mvvm.R

/**
 * 无参构造的MyObserver只能感知Activity的生命周期发生了变化，无法主动获知当前的生命周期状态
 *
 * 在MyObserver的构造函数中将Lifecycle对象穿进来即可
 */
class MyObserver(val lifecycle: Lifecycle?) : LifecycleObserver {

    constructor() : this(lifecycle = null)

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.d("MyObserver", "activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.d("MyObserver", "activityStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun activityResume() {
        Log.d("MyObserver", "activityResume")
    }

}

class MainActivityObserver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 当Activity的声明周期发生变化时需要通知MyObserver
         * 此时需要借助LifecycleOwner，语法如下：
         * lifecycleOwner.lifecycle.addObserver(MyObserver())
         *
         * 只要Activity继承自AppCompatActivity，或者Fragment是继承自androidx.fragment.app.Fragment
         * 那么它们本身就是一个LifecycleOwner的实例，
         */
        lifecycle.addObserver(MyObserver())
    }

}

/**
 * 继承自Activity则需要手动实现LifecycleOwner接口，重写getLifecycle()方法
 */
class LifeActivity : Activity(), LifecycleOwner {

    private var mLifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyObserver())
    }

    /**
     * 返回LifecycleRegistry对象
     */
    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }
}