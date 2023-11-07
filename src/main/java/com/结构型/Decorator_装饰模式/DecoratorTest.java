package com.结构型.Decorator_装饰模式;

public class DecoratorTest {
    public static void main(String[] args) {
        Base base = new BaseImpl();
        Decorator decorator = new DecoratorImpl(base);  //将Base实现装饰一下
        Decorator outer = new DecoratorImpl(decorator);  //装饰者还可以嵌套
        decorator.test();
        outer.test();
    }
}

// 目标类
abstract class Base{
    public abstract void test();
}

// 目标类对象
class BaseImpl extends Base{
    @Override
    public void test() {
        System.out.println("我是业务方法");   //具体的业务方法
    }
}

// 装饰者
class Decorator extends Base{   //装饰者需要将装饰目标组合到类中

    protected Base base; // 目标类对象

    public Decorator(Base base) {
        this.base = base;
    }

    @Override
    public void test() {
        base.test();    //这里暂时还是使用目标的原本方法实现
    }
}

class DecoratorImpl extends Decorator{   //装饰实现

    public DecoratorImpl(Base base) {
        super(base);
    }

    @Override
    public void test() {    //对原本的方法进行装饰，我们可以在前后都去添加额外操作
        System.out.println("装饰方法：我是操作前逻辑");
        super.test();
        System.out.println("装饰方法：我是操作后逻辑");
    }
    // 装饰模式对类的功能进行了扩展
}