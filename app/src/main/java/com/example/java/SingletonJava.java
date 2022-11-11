package com.example.java;

/*
    单例模式Java写法
 */
public class SingletonJava {

    private static SingletonJava instance;

    /**
     * 禁止外部创建SingletonJava实例，使用private关键字
     */
    private SingletonJava() {
    }

    /**
     * 给外部提供一个getInstance()静态方法用于获取SingletonJava实例
     * @return SingletonJava
     */
    public synchronized static SingletonJava getInstance() {
        if (instance == null) {
            instance = new SingletonJava();
        }
        return instance;
    }

    public void singletonTest() {
        System.out.println("Java singletonTest is called");
    }
}
