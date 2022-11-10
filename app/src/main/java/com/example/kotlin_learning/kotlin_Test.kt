package com.example.kotlin_learning

fun largerNumber(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}

/**
 * Kotlin中的if语句相比于Java有一个额外的功能，它是可以有返回值的，返回值就是if语句每一个条件中最后一行代码的返回值
 */
fun largerNumber1(num1: Int, num2: Int): Int {
    val value = if (num1 > num2) {
        num1
    } else {
        num2
    }
    return value
}

fun largerNumber2(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

/**
 * 当一个函数只有一行代码时，可以省略函数体部分，直接将这一行代码使用等号串连在函数定义的尾部
 */
fun largerNumber3(num1: Int, num2: Int) = if (num1 > num2) {
    num1
} else {
    num2
}

fun largerNumber4(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

fun getScore(name: String) =
    if (name == "Tom") println(86) else if (name == "Jimmy") println(85) else println("not this")

fun getScore1(name: String) = when (name) { //直接使用when作为返回值，需要else
    "Tom" -> {
        name
    }
    "sjy" -> name //当你的执行逻辑只有一行代码时，{ }可以省略
    else -> "not"
}

fun getScore2(name: String) {
    when (name) {
        "Tom" -> {
            name
        }
        "sjy" -> name //当你的执行逻辑只有一行代码时，{ }可以省略
    }
}

fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("num is Int")
        is Double -> println("num is Double")
        else -> println("num is not Number")
    }
}

fun checkWhen(name: String) = //when的不带参数用法
    when {
        name == "Tom" -> 11
        name.startsWith("To") -> 22
        name == "Echo" -> 33
        else -> 0
    }


fun main() {

//    for (i in 0..10){ //[0,10]
//        println(i)
//    }
//    for (i in 0 until 10){ //[0,10)
//        println(i)
//    }
//
//    for (i in 0..10 step 2){ //{0,2,4,6,8,10}
//        println(i)
//    }

//    for (i in 10 downTo 1) { //{10,9,8,7,6,5,4,3,2,1}
//        println(i)
//    }

//    println(largerNumber4(1,20))
//    println(getScore1("Tom"))
//    checkNumber(10)
    println(checkWhen("Tom"))
}