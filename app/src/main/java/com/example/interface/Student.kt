package com.example.`interface`

import com.example.kotlin_learning.Person

class Student(name: String, age: Int) : Person(name, age), Study { //继承Student父类，实现Study接口
    override fun readBooks() {
        println("$name is readBooks")
    }

    override fun doHomeorks() {
        println("$name is doHomeworks")
    }

}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomeorks()
}

fun main() {
    val student = Student("sjy", 19)
    doStudy(student)
}