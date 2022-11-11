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
    println(maxArrayList)
}