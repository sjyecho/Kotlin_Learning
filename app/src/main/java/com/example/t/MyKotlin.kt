package com.example.t

/**
 * 泛型实化
 */

/*内联函数的基本用法 Start*/
fun foo(str: String) {
    bar<String>(str) { println(str) }
}

inline fun <T> bar(str: String, block: (String) -> Unit) {
    block(str)
}
/*内联函数的基本用法 End*/

/**
 * Java的泛型功能依赖于类型擦除机制
 * 泛型对于类型的约束只在编译器存在，运行时JVM识别不了在代码中指定的泛型类型
 *
 * getGenericType()直接返回了当前指定泛型的实际类型
 */
inline fun <reified T> getGenericType() = T::class.java

fun main() {
    foo("sjy")

    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}