package com.设计模式.单例模式;

public class Main {
    public static void main(String[] args) {

    }
}

// 恶汉式: 类在进行加载的时候立即进行实例化操作
// private static Singleton singleton = new Singleton();
class Singleton{
    // 唯一的实例, 即类变量,静态变量,用static修饰
    private static Singleton singleton = new Singleton();
    private Singleton() {} // 构造方法是私有的

    public static Singleton getInstance(){
        return singleton;
    }
}

// 懒汉式: 类加载的时候不进行实例化, 在第一次使用的时候再进行实例化
/*
class SingletonTest{
    // 唯一的实例, 即类变量,静态变量,用static修饰
    private static SingletonTest singleton;
    private SingletonTest() {} // 构造方法是私有的

    // 需要加锁
    public synchronized static SingletonTest getInstance(){
        if (singleton == null) {
                singleton = new SingletonTest();
        }
        return singleton;
    }
}
* */

// 懒汉式:双重检测锁
class SingletonTest{
    // 唯一的实例, 即类变量,静态变量,用static修饰
    private volatile static SingletonTest singleton;
    private SingletonTest() {} // 构造方法是私有的

    // 需要加锁
    public static SingletonTest getInstance(){
        if (singleton == null) {
           synchronized (SingletonTest.class) {
               if (singleton == null)
                   singleton = new SingletonTest();
           }
        }
        return singleton;
    }
}
