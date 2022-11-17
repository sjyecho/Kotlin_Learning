package com.example.kotlin_learning

/**
 * 委托模式
 *
 * MySet的构造函数接收了一个HashSet参数，这就相当于一个辅助对象
 * 然后在Set接口所有的方法实现中，我们都没有进行自己的实现，而是调用了辅助对象中相应的方法实现
 */
class MySet<T>(private val helperSet: HashSet<T>) : Set<T> {

    override val size: Int
        get() = helperSet.size

    override fun contains(element: T) = helperSet.contains(element)


    override fun containsAll(elements: Collection<T>): Boolean {
        return helperSet.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return helperSet.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return helperSet.iterator()
    }
}

/**
 * 现在的MySetTwo就成为了一个全新的数据结构类
 * 不仅永远不会为空(isEmpty()永远返回false)，而且还能打印helloWorld
 * 至于其他Set接口中的功能，则和HashSet保持一致
 */
class MySetTwo<T>(private val helperSet: HashSet<T>) : Set<T> by helperSet {

    fun helloWorld() = println("hello world")

    override fun isEmpty() = false
}