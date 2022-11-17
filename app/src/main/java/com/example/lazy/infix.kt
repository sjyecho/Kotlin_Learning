package com.example.lazy

/**
 * 给String类扩展一个beginsWith()函数
 * 加上infix关键字后，beginsWith()函数就变成了infix函数
 *
 * infix语法糖限制
 *  1.infix函数是不能定义成顶层函数的，它必须是某个类的成员函数，可以使用扩展函数的方式将它定义到某个类当中
 *  2.infix函数必须接收且只能接收一个参数
 */
infix fun String.beginsWith(prefix: String) = startsWith(prefix)

fun main() {
    if ("Hello Kotlin" beginsWith "Hello") println("true") else println("false")

}