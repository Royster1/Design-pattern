package com.设计原则.合成复用原则;

public class Main {
    public static void main(String[] args) {
        new B(new A()).test();
    }
}

class A {
    public void connectDatabase(){
        System.out.println("我是连接数据库操作！");
    }
}

class B {

    A a;
    public B(A a){   //在构造时就指定好
        this.a = a;
    }

    public void test(){
        System.out.println("我是B的方法，我也需要连接数据库！");
        a.connectDatabase();   //也是通过对象A去执行
    }
}
