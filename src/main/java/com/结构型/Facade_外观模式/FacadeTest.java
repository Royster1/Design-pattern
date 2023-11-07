package com.结构型.Facade_外观模式;

public class FacadeTest {

    public static void main(String[] args) {
        Facade facade = new Facade(); // 降低了类与类直接的关联程度
        facade.marry();
    }
}

class SubSystemA {
    public void test1(){
        System.out.println("排队");
    }
}

class SubSystemB {
    public void test2(){
        System.out.println("结婚");
    }
}

class SubSystemC {
    public void test3(){
        System.out.println("领证");
    }
}

class Facade {

    SubSystemA a = new SubSystemA();
    SubSystemB b = new SubSystemB();
    SubSystemC c = new SubSystemC();

    public void marry(){   //红白喜事一条龙服务
        a.test1();
        b.test2();
        c.test3();
    }
}