package com.example.t

fun main() {
    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name},${t.age}"
        }
    }
    // handleTransformer(trans) //无法通过编译
    handleTransformer(trans)
}

fun handleTransformer(trans: Transformer<Student>) {
    val student = Student("Tom", 19)
    val result = trans.transform(student)
}

// 在下放T前加上in，上述handleTransformer(trans)即可通过编译
// 即意味着Transformer在泛型T上是逆变的
interface Transformer<in T> {
    fun transform(t: T): String
}