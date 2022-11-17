package com.example.inline

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 可以直接在SharedPreferences对象上调用open函数
         * 注意，现在Lambda表达式拥有的是SharedPreferences.Editor的上下文环境
         * 因此这里可以直接调用相应的put方法来添加数据
         */
        getSharedPreferences("data", Context.MODE_PRIVATE).open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }

        val values =
            cvOf("name" to "Game of Thrones", "author" to "George Martin", "price" to "20.55")
        // db.insert("Books",null,values)
    }

    /**
     * 通过扩展函数的方式向SharedPreferences类中添加了一个open函数，并且还接收一个函数类型的参数，这是一个高阶函数
     * 由于open函数拥有SharedPreferences的上下文，因此这里可以直接调用edit()方法来获取SharedPreferences.Editor对象
     * 另外open函数接收的是一个SharedPreferences.Editor的函数类型参数，因此这里需要调用editor.block()对函数类型参数进行调用，
     * 我们就可以在函数类型参数的具体实现中添加数据了，最后调用editor.apply()方法来提交数据
     */
    private fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        editor.block()
        editor.apply()
    }

    /**
     * cvOf()方法接收了一个Pair参数，也就是A to B语法结构创建出来的参数类型
     * 在参数前面加上了一个vararg关键字，对应的就是Java中的可变参数列表
     * 允许向这个方法传入0个、1个、2个......Pair类型的参数
     * 这些参数都会被赋值到使用vararg声明的这一个变量上面
     * 然后使用for-in循环可以将传入的所有参数遍历出去
     */
    private fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues {
        val cv = ContentValues()
        for (pair in pairs) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is Int -> cv.put(key, value)
                is Long -> cv.put(key, value)
                is Short -> cv.put(key, value)
                is Float -> cv.put(key, value)
                is Double -> cv.put(key, value)
                is Boolean -> cv.put(key, value)
                is String -> cv.put(key, value)
                is Byte -> cv.put(key, value)
                is ByteArray -> cv.put(key, value)
                null -> cv.putNull(key)
            }
        }
        return cv
    }

    /**
     * 使用apply函数
     */
    fun cvOF(vararg pairs: Pair<String, Any?>) = ContentValues().apply {
        for (pair in pairs) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is Int -> put(key, value)
                is Long -> put(key, value)
                is Short -> put(key, value)
                is Float -> put(key, value)
                is Double -> put(key, value)
                is Boolean -> put(key, value)
                is String -> put(key, value)
                is Byte -> put(key, value)
                is ByteArray -> put(key, value)
                null -> putNull(key)
            }
        }
    }
}