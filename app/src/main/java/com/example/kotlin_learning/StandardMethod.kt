package com.example.kotlin_learning

val list = listOf("Apple", "banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()

fun main() {
    builder.append("Start eating fruits.\n")
    for (fruit in list) {
        builder.append(fruit).append("\n")
    }
    builder.append("eat all fruits")
    val result = builder.toString()
    println(result)

    /*
        标准函数with
        with接收两个参数：第一个参数可以是一个任意类型的对象
                        第二个参数是一个Lambda表达式，并使用Lambda表达式中的最后一行代码作为返回值返回
     */
    // with函数传入一个StringBuilder对象，接下来整个Lambda表达式的上下文就会是这个StringBuilder对象
    val resultWith = with(StringBuilder()) {
        append("Start eating fruits by with.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("eat all fruits by with")
        toString()
    }
    println(resultWith)

    // 标准函数run
    val resultRun = StringBuilder().run {
        append("Start eating fruits by run.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("eat all fruits by run")
        toString()
    }
    println(resultRun)

    // 标准函数apply
    val resultApply = StringBuilder().apply {
        append("Start eating fruits by run by apply.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("eat all fruits by run by apply")
    }
    println(resultApply.toString())
}