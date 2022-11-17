package com.example.kotlin_learning

class MyClass<T> {

    fun method(param: T): T {
        return param
    }

    fun <T> method2(param: T): T {
        return param
    }

    /**
     * 将方法的泛型上界设置为Number类型
     * 表示我们只能将方法的泛型指定为数字类型，如Int、Float、Double
     */
    fun <T : Number> method3(param: T): T {
        return param
    }

    /**
     * 为StringBuilder扩展的build函数作用与apply函数相似
     * 不过apply可以应用在所有类，build只能用在StringBuilder类上
     */
    fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
        block()
        return this
    }

    /**
     * 将build定义为所有类可用
     */
    fun <T> T.build(block: T.() -> Unit): T {
        block()
        return this
    }
}