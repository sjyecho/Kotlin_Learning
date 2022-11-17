package com.example.lazy

import kotlin.reflect.KProperty

// 顶层函数
fun <T> later(block: () -> T) = Later(block)

class Later<T>(val block: () -> T) {
    var value: Any? = null

    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}

fun main(){
    val p by later {
        println("run codes inside later block")
        "test later"
    }
}