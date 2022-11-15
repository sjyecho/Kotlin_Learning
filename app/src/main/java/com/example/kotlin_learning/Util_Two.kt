package com.example.kotlin_learning

/**
 * 与单例类不同，将之改为普通类
 */
class Util_Two {

    /**
     * 此方法需要创建Util类的实例才能调用
     */
    fun doAction1() {
        println("do action")
    }

    /**
     * 此方法可以直接使用Util_Two.doAction2()调用
     */
    companion object {

        /**
         * 加上@JvmStatic注解，Kotlin编译器就会将这些方法编译成真正的静态方法
         * 如果不加，在Java代码中无法以静态方法的形式调用
         */
        @JvmStatic
        fun doAction2() {
            println("do action2")
        }
    }
}