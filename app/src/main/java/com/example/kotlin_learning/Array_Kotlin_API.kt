package com.example.kotlin_learning

fun main() {

    val list = listOf("Apple", "Banana", "Pear", "Grape")

    var arrayLength = ""
    for (fruit in list) {
        if (fruit.length > arrayLength.length) {
            arrayLength = fruit
        }
    }
    println(arrayLength)

    val maxArrayList = list.maxBy { it.length }

    val lambda = { fruit: String -> fruit.length }
    list.maxBy(lambda)

    list.maxBy({ fruit: String -> fruit.length })

    //Kotlin规定，当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
    list.maxBy() { fruit: String -> fruit.length }

    //如果Lambda参数是函数的唯一一个参数的话，还可以将函数的括号省略
    list.maxBy { fruit: String -> fruit.length }

    list.maxBy { fruit -> fruit.length }

    //当Lambda表达式的参数列表中只有一个参数时，也不必声明参数名，而是可以使用it关键字来代替
    list.maxBy { it.length }

    println("maxLengthFruit is $maxArrayList")

    val newList = list.map { it.uppercase() }
    for (fruit in newList) {
        println("newList is $fruit")
    }

    /*
        先过滤再转换，提高运行效率
     */
    val newList1 = list.filter { it.length <= 5 }.map { it.uppercase() }
    for (fruit in newList1) {
        println("newList1 is $fruit")
    }

    val anyResult = list.any { it.length <= 5 } //return Boolean
    val allResult = list.all { it.length <= 5 } //return Boolean
    println("anyResult is $anyResult，allResult is $allResult")

    Thread(Runnable {
        println("Thread is running")
    }).start()

    Thread {
        println("Thread is running")
    }.start()

    printParams(str = "sjy")
}

fun printParams(num: Int = 100, str: String) {
    println("num is $num,str is $str")
}