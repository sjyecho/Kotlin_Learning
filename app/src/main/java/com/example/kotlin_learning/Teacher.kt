package com.example.kotlin_learning

class Teacher : Person { //此时的Teacher没有主构造函数，继承Person不需要加()
    constructor(name: String, age: Int) : super(name, age) //因为没有主构造函数，次构造函数只能直接调用父类的构造函数，关键字需要用super
}