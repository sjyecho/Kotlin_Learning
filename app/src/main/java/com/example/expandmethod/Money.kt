package com.example.expandmethod

/*
    运算符重载使用的是operator关键字
    只要在指定函数的前面加上operator关键字
    例如，加号运算符对应的是plus()函数，减号运算符对应的是minus()函数
 */
data class Money(val value: Int) { // 使用关键字data，自动识别为数据类，自动重写equals()、hashCode()、toString()

    operator fun plus(money: Money): Money {
        val sum = value + money.value
        println(value)
        println(money.value)
        return Money(sum)
    }

    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }
}

/*fun getRandomLengthString(str: String): String {
    val n = (1..20).random()
    println("n : $n")
    val builder = StringBuilder()
    repeat(n) {
        builder.append(str)
    }
    return builder.toString()
}*/

fun getRandomLengthString(str: String) = str * (1..20).random()

/*operator fun String.times(n: Int): String {
    val builder = StringBuilder()
    repeat(n) {
        builder.append(this)
    }
    return builder.toString()
}*/

//Kotlin的String类中已经提供了一个用于将字符串重复n遍的repeat()函数，
//因此times()函数还可以进一步精简成如下形式
operator fun String.times(n: Int) = repeat(n)

fun main() {
    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1 + money2// money1.plus(money2)
    println(money3)
    println(money3 + 15)
    println(getRandomLengthString("string "))
    println("abc " * 3)
}