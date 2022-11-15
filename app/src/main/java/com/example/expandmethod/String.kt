package com.example.expandmethod

/*
    扩展String类的方法
 */
fun String.letterCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

fun main(){
    val count = "ASDASD13213DASD".letterCount()
    println(count)
}