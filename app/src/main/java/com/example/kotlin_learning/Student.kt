package com.example.kotlin_learning

class Student(val sno: String, val grade: Int, name: String, age: Int) :
    Person(name, age) { //Student继承Person，因为此时Student类存在主构造函数，继承的Person后面需要加()
    constructor(name: String, age: Int) : this("", 0, name, age) //创建第一个次构造函数，this调用主构造函数
    constructor() : this("", 0) //创建第二个次构造函数，this调用上面的次构造函数
}

fun main() {
    val student1 = Student()
    val student2 = Student("sjy", 11)
    val student3 = Student("一", 1, "sjy", 20)
}