package com.example.t

//import android.content.Context
//import android.content.Intent
//
///**
// * 如果需要启动TestActivity，只需这么写
// * startActivity<TestActivity>(context)
// */
//inline fun <reified T> startActivity(context: Context) {
//    /*
//    * Kotlin中双冒号 ::
//    * 表示把一个方法当做一个参数，传递到另一个方法中进行使用
//    * 也就是引用一个方法
//    * */
//    val intent = Intent(context, T::class.java)
//    context.startActivity(intent)
//}
//
//inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
//    val intent = Intent(context, T::class.java)
//    intent.block()
//    context.startActivity(intent)
//}