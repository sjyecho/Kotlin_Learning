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

fun main() {
    val num1 = 100
    val num2 = 80
//    val result1 = num1AndNum2(num1, num2, ::plus)
//    val result2 = num1AndNum2(num1, num2, ::minus)
    val result1 = num1AndNum2(num1, num2) { n1, n2 -> n1 + n2 }
    val result2 = num1AndNum2(num1, num2) { n1, n2 -> n1 - n2 }
    println("result1 is $result1")
    println("result2 is $result2")
}