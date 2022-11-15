package com.example.`interface`

//密封类
/*
    密封类及其所有子类只能定义在同一个文件的顶层位置，
    不能嵌套在其他类中，这是被密封类底层的实现机制所限制的
 */
//interface Result -> sealed class Result
sealed class Result
class Success(val msg: String) : Result() // 继承Result
class Failure(val error: Exception) : Result() // 继承Result

fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message

    /*
        使用sealed class Result，不再需要else
        当在when语句中传入一个密封类变量作为条件时，Kotlin编译器会自动检查该密封类有哪些子类，
        并强制要求你将每一个子类所对应的条件全部处理。
        这样就可以保证，即使没有编写else条件，也不可能会出现漏写条件分支的情况
     */
    //else -> throw IllegalArgumentException()
}