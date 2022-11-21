package com.example.mvvm

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // path : /data/data/com.example.mvvm/shared_prefs/MainActivity.xml
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this, MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        findViewById<TextView>(R.id.infoText).text = countReserved.toString()
        findViewById<Button>(R.id.plusOneBtn).setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
        findViewById<Button>(R.id.clearBtn).setOnClickListener {
            viewModel.counter = 0
            refreshCounter()
        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter)
        }
    }

    private fun refreshCounter() {
        findViewById<TextView>(R.id.infoText).text = viewModel.counter.toString()
    }
}