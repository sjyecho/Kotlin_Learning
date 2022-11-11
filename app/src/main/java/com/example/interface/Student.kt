package com.example.`interface`

import com.example.kotlin_learning.Person

class Student(name: String, age: Int) : Person(name, age), Study { //继承Student父类，实现Study接口
    override fun readBooks() {
        println("$name is readBooks")
    }

    override fun doHomeworks() {
        println("$name is doHomeworks")
    }

}

fun doStudy(study: Study?) { // ? 表示允许传入为null，若不加 ? 代表不允许传入null
    if (study != null) { // 使用 ? 时，下面两个方法需要空指针保护
        study.readBooks()
        study.doHomeworks()
    }

    study?.readBooks()
    study?.doHomeworks()
}

fun operationNull(a: Student?, b: Student?) {
    val c = if (a != null) {
        a
    } else {
        b
    }

    val d = a ?: b // ?: 代表若a不为null则返回a，若a为null则返回b
}

fun getTextLength(text: String?): Int {
    if (text != null) {
        return text.length
    }
    return 0
}

fun getTextLengthMore(text: String?) = text?.length ?: 0

var student: Student? = null
fun doSomething(student: Student?) {
//    if (student != null) {
        //if不可以处理全局变量的判空问题，因为全局变量随时都有可能被其他线程所修改
//        student.readBooks()
//        student.doHomeworks()
//    }

    student?.let { student ->
        student.readBooks()
        student.doHomeworks()
    }

    student?.let {
        it.doHomeworks()
        it.readBooks()
    }
}

fun main() {
    val student = Student("sjy", 19)
    doStudy(student)
    doSomething(student)
}