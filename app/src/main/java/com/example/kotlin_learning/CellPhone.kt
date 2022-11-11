package com.example.kotlin_learning

data class CellPhone(val brand: String, val price: Double) //使用关键字data，自动识别为数据类，自动重写equals()、hashCode()、toString()
                                                           //当一个类中没有任何代码时，还可以将尾部的大括号省略

fun main() {
    val cellPhone1 = CellPhone("oppo", 1000.0)
    val cellPhone2 = CellPhone("oppo", 1000.0)
    val cellPhone3 = CellPhone("vivo", 1000.0)
    println(cellPhone1)
    println(cellPhone2)
    println(cellPhone3)
    println(cellPhone1 == cellPhone2)
    println(cellPhone3 == cellPhone2)
}