package com.example.kotlin_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Adapter

/**
 * 对变量延迟初始化
 */
class MainActivity : AppCompatActivity(), OnClickListener {

    // 将adapter1设置为全局变量，在onCreate()中进行初始化，需要用到 ?=
    // 但在后续使用时需要判空
    // 若全局变量太多，则存在大量判空
    private var adapter1: Adapter? = null

    // 使用关键字lateinit延迟初始化，不需要一开始将之赋值为null
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!::adapter.isInitialized) {
            // 判断adapter变量是否已经初始化
        }
    }

    override fun onClick(v: View?) {
        adapter1?.isEmpty
        adapter.isEmpty
    }
}