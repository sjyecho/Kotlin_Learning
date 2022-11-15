package com.example.expandmethod

/**
 * 定义高阶函数
 */

fun num1AndNum2(num1: Int, num2: Int, operator: (Int, Int) -> Int): Int {
    val result = operator(num1, num2)
    return result
}

//fun plus(num1: Int, num2: Int): Int {
//    return num1 + num2
//}
//
//fun minus(num1: Int, num2: Int): Int {
//    return num1 - num2
//}

/*
    block: T.() -> T
    1.传入的函数无参
    2.该函数最后一行需要是调用者对象类型，而且无return
    3.把调用者作为this,传入定义的lambda表达式函数域中
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun main() {
    val num1 = 100
    val num2 = 80
//    val result1 = num1AndNum2(num1, num2, ::plus)
//    val result2 = num1AndNum2(num1, num2, ::minus)
    val result1 = num1AndNum2(num1, num2) { n1, n2 -> n1 + n2 }
    val result2 = num1AndNum2(num1, num2) { n1, n2 -> n1 - n2 }
    println("result1 is $result1")
    println("result2 is $result2")

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits by build.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits by build.")
    }
    println(result.toString())
}