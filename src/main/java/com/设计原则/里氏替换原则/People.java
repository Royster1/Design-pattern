package com.设计原则.里氏替换原则;

public abstract class People {

    public abstract void coding();   //这个行为还是定义出来，但是不实现

    class Coder extends People{ // 父类依然写代码
        @Override
        public void coding() {
            System.out.println("我会打代码");
        }
    }


    class JavaCoder extends People{ // 子类不再重写父类的写代码方法了, 因为现在继承的是people类,该coding方法是抽象的
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }

        public void coding() {
            System.out.println("摆烂了，啊对对对");
        }
    }
}