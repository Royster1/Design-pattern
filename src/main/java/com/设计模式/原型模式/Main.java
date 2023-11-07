package com.设计模式.原型模式;

public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.getName() + " " + plane.getType());

        // 赋值
        Plane clone = (Plane) plane.clone();
        System.out.println(clone.getName() + " " + clone.getType());
    }
}

// 原型接口
interface Prototype{
    Object clone();
}

// 飞机类 - 需要被克隆的对象
class Plane implements Prototype{
    private String name;
    private String type; // 都是私有类, 我们复制不了啊

    public Plane() {
        name = "name:" + Math.random();
        type = "type:" + Math.random();
    }

    // 需要提供新的构造器, 把原型对象传入进去, 就可以通过构造器访问到原型对象的内部属性, 在一个类的内部可以访问这个对象的私有成员的
    public Plane(Plane plane){
        this.name = plane.name;
        this.type = plane.type;
    }

    public String getName(){return name;}

    public String getType(){return type;}

    @Override
    public Object clone() {
        return new Plane(this);
    }
}