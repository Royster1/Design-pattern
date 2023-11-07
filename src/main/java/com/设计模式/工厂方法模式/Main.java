package com.设计模式.工厂方法模式;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Factory factory = new HuaWeiFactory();
        Phone phone = factory.createPhone();
        phone.print();
    }
}

// 产品继承抽象产品
class iPhone implements Phone{
    @Override
    public void print() {
        System.out.println("苹果手机");
    }
}
class HuaWeiPhone implements Phone{
    @Override
    public void print() {
        System.out.println("华为手机");
    }
}

// 抽象工厂
interface Factory{
    Phone createPhone();
}

// 子工厂继承抽象工厂
class IphoneFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new iPhone();
    }
}
class HuaWeiFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}



