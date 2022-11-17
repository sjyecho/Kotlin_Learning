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

/**
 * 使用泛型函数的定义方法，从而使得has()函数可以接收任意具体类型的参数
 * 也就是has()函数和contains()函数的功能实际上是一模一样的，只是多了个infix关键字，从而拥有了infix函数的语法糖功能
 */
infix fun <T> Collection<T>.has(element: T) = contains(element)

fun main() {
    if ("Hello Kotlin" beginsWith "Hello") println("true") else println("false")

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    if (list.contains("Banana")) {
        // 处理具体的逻辑
    }
    if (list has "Banana"){
        // 处理具体的逻辑
    }
}