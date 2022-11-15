package com.example.inline

import android.content.SharedPreferences

inline fun num1AndNum2(num1: Int, num2: Int, operator: (Int, Int) -> Int): Int {
    val result = operator(num1, num2)
    return result
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun printStringInline(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

/*
    此处无法使用inline
    cause:在runRunnable()函数中，创建了一个Runnable对象，在Lambda表达式中调用了传入的函数类型参数。
          而Lambda表达式在编译的时候会被转换为匿名内部类
          也就是说，下述代码实际上是在匿名类中调用了传入的函数类型参数
          而内联函数所引用的Lambda表达式允许使用return关键字进行函数返回，但由于是在匿名类中调用的函数类型参数，此时无法进行外层调用函数返回的
          最多只能对匿名类中的函数调用进行返回，所以会出现错误提示
    solve:额外使用crossinline,它用于保证内联函数的Lambda表达式中一定不会使用return关键字，但仍然可以使用return@runRunnable进行局部返回
*/
inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

/**
 * 通过扩展函数的方式向SharedPreferences类中添加了一个open函数，并且还接收一个函数类型的参数，这是一个高阶函数
 * 由于open函数拥有SharedPreferences的上下文，因此这里可以直接调用edit()方法来获取SharedPreferences.Editor对象
 * 另外open函数接收的是一个SharedPreferences.Editor的函数类型参数，因此这里需要调用editor.block()对函数类型参数进行调用，
 * 我们就可以在函数类型参数的具体实现中添加数据了，最后调用editor.apply()方法来提交数据
 */
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}

fun main() {
    println(num1AndNum2(1, 2) { n1, n2 -> n1 + n2 })

    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return@printString // Lambda表达式中是不允许直接使用return关键字的，
        // 这里使用return@printString写法，表示进行局部返回，
        // 并且不再执行Lambda表达式的剩余部分代码
        println(s)
        println("lambda end")
    }
    println("main end")

    println("main start")
    val str1 = ""
    printStringInline(str1) { s -> // printStringInline是内联函数，可以在Lambda表达式中使用return关键字
        // 此时return代表的是返回外层的调用函数，也就是main()函数
        println("lambda start")
        if (s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")
}