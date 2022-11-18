package com.example.t

/**
 * 泛型的协变
 */
open class Person(val name: String, val age: Int)
class Student(name: String, age: Int) : Person(name, age)
class Teacher(name: String, age: Int) : Person(name, age)

/**
 * 如何让MyClass<A>成为MyClass<B>的子类型呢
 * 如果一个泛型类在其泛型类型的数据上是只读的话，那么它是没有类型转换安全隐患的
 * 而要实现这一点，则需要让MyClass<T>类中所有方法都不能接收T类型的参数
 * 即，T只能出现在out位置，不能出现在in位置上
 *
 *      interface MyClass<T>{
 *          fun method(param T):T
 *      }
 *      方法中第一个T处于in位置
 *      方法中第二个T处于out位置
 */
class SimpleData<T> {

    private var data: T? = null

    fun set(t: T?) {
        data = t
    }

    fun get(): T? {
        return data
    }
}

/**
 * 在泛型T的声明前面加上了一个out关键字，这就意味着T只能出现在out位置上，而不能出现在in位置上
 * 同时也意味着SimpleData在泛型T上是协变的
 */
class SimpleData2<out T>(private val data: T?) {
    fun get(): T? {
        return data
    }
}

fun handleSimpleData(data: SimpleData<Person>) {
    val teacher = Teacher("Jack", 35)
    data.set(teacher)
}

fun handleMyData(data2: SimpleData2<Person>) {
    val personData = data2.get()
}

fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>()
    data.set(student)

    /*
    * 编译无法通过
    * 因为在handleSimpleData()方法中存在Teacher类的实例
    * 而Teacher类和Student类是无法相互转换的
    * */
    // handleSimpleData(data)
    val studentData = data.get()

    val data2 = SimpleData2(student)
    /**
     * 由于SimpleData类已经进行了协变声明，那么SimpleData<Student>自然就是SimpleData<Person>的子类了，
     * 所以这里可以安全地向handleMyData()方法中传递参数
     */
    handleMyData(data2)
    val studentData2 = data2.get()

}