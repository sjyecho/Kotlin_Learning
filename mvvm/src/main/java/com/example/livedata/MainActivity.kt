package com.example.livedata

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences
    lateinit var plusOneBtn: Button
    lateinit var clearBtn: Button
    lateinit var infoText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        plusOneBtn = findViewById(R.id.plusOneBtn)
        infoText = findViewById(R.id.infoText)
        clearBtn = findViewById(R.id.clearBtn)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this, MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener { viewModel.plusOne() }
        clearBtn.setOnClickListener { viewModel.clear() }

        /**
         * observe()方法接收两个参数：
         * 第一个参数是一个LifecycleOwner对象，Activity本身就是一个LifecycleOwner对象，因此直接传this就好
         * 第二个参数是一个Observer接口，当counter中包含的数据发生变化时，就会回调到这里，因此在这里将最新的计数更新到界面上
         */
        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}