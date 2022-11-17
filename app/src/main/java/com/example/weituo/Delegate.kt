package com.example.weituo

import kotlin.reflect.KProperty

class Delegate {

    var propValue: Any? = null

    /**
     * 第一个参数：用于声明该Delegate类的委托功能可以在什么类中使用，这里写成MyClass表示仅可在MyClass类中使用
     * 第二个参数：KProperty<*>是Kotlin中的一个属性操作类，可用于获取各种属性相关的值，在当前场景下用不着，但是必须在方法参数上进行声明
     *
     * 另外，<*>这种泛型的写法表示你不知道或者不关心泛型的具体类型，只是为了通过语法编译而已，有点类似于Java中<?>的写法
     * 至于返回值可以声明成任何类型，根据具体的实现逻辑去写就行了，以下代码只是一种示例写法
     */
    operator fun getValue(myClass: MyClass, prop: KProperty<*>): Any? {
        return propValue
    }

    /**
     * 前两个参数和getValue()方法是相同的
     * 最后一个参数表示具体要赋值给委托属性的值
     * 这个参数的类型必须和getValue()方法返回值的类型保持一致
     */
    operator fun setValue(myClass: MyClass, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}