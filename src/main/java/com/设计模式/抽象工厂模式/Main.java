package com.设计模式.抽象工厂模式;



public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new SuperFactory();
        Mask mask = factory.createMask("n95");
        System.out.println(mask);
    }
}

// 抽象工厂
interface AbstractFactory{
    Phone createPhone(String param);
    Mask createMask(String parm);
}

// 具体工厂
class SuperFactory implements AbstractFactory{

    @Override
    public Phone createPhone(String param) {
        return new iPhone();
    }

    @Override
    public Mask createMask(String parm) {
        return new N95();
    }
}

// 抽象产品
interface Mask{}
interface Phone{}

// 具体产品
class N95 implements Mask{}
class iPhone implements Phone{}