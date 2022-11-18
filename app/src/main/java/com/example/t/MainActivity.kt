package com.example.t

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_learning.R

/**
 * 泛型实化的应用
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        startActivity<TestActivity>(this) {
            putExtra("param1", "data")
            putExtra("param2", "123")
        }
    }

    /**
     * 如果需要启动TestActivity，只需这么写
     * startActivity<TestActivity>(context)
     */
    inline fun <reified T> startActivity(context: Context) {
        /*
        * Kotlin中双冒号 ::
        * 表示把一个方法当做一个参数，传递到另一个方法中进行使用
        * 也就是引用一个方法
        * */
        val intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }

    /**
     * 重载startActivity()，使得Intent可以附带一些参数
     */
    private inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        val intent = Intent(context, T::class.java)
        intent.block()
        context.startActivity(intent)
    }

}