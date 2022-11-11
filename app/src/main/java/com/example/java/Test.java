package com.example.java;

import com.example.kotlin_learning.Singleton;

public class Test {

    public static void main(String[] args) {

        SingletonJava singletonJava = SingletonJava.getInstance();
        singletonJava.singletonTest();


        Singleton.INSTANCE.singletonTest();

        Singleton singleton = Singleton.INSTANCE;
        singleton.singletonTest();
    }
}
