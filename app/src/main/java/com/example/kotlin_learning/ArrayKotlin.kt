package com.example.kotlin_learning

fun main() {

    /*
        Kotlin提供的一个内置的listOf()函数来简化初始化集合
        listOf()函数创建的是一个不可变的集合
        Kotlin不可变的集合是指该集合只能用于读取
     */
    val list = listOf("Apple", "Banana", "Pear", "Grape")

    for (fruit in list) {
        println(fruit)
    }

    /*
        使用mutableListOf()函数
     */
    val mutableListOf = mutableListOf("Apple", "Banana", "Pear", "Grape")
    mutableListOf.add("sjy")
    for (fruit in mutableListOf) {
        println(fruit)
    }

    /*
        set
     */
    val set = setOf("Apple", "Banana", "Pear", "Grape")
    for (fruit in set) {
        println(fruit)
    }

    /*
        map
     */
    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Pear"] = 3
    map["Grape"] = 4
    val map1 = mapOf("Apple" to 1, "Banana" to 2, "Pear" to 3, "Grape" to 4)
    for ((fruit, number) in map1) {
        println("fruit is $fruit,number is $number")
    }
}