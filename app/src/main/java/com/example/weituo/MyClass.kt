package com.example.weituo

/**
 * 当我们给MyClass的p属性赋值时，就会调用Delegate类的setValue()方法
 * 当获取MyClass中p属性的值时，就会调用Delegate类的getValue()方法
 */
class MyClass {

    var p by Delegate()

}