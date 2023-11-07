package com.结构型.Bridge_桥接模式;

public class BridgeTest {
    // 奶茶类型是固定的, 杯子尺寸是抽象的, 我们需要把抽象化与实现化解耦，使得二者可以独立变化
    public static void main(String[] args) {
        KissTea tea = new KissTea(new Large()); // 尺寸是抽象的
        System.out.println(tea.getType());
        System.out.println(tea.getSize());

        // 波波芋圆奶茶-小杯
        KissTea tea2 = new KissTea(new Small()); // 尺寸是抽象的
        System.out.println(tea2.getType());
        System.out.println(tea2.getSize());
    }
}
interface Size {   //分大杯小杯中杯
    String getSize();
}

abstract class AbstractTea { // 奶茶抽象类
    protected Size size;   //尺寸作为桥接属性存放在类中
    protected AbstractTea(Size size){   //在构造时需要知道尺寸属性
        this.size = size;
    }

    public abstract String getType();   //具体类型依然是由子类决定

}
abstract class RefinedAbstractTea extends AbstractTea{ // 添加其他维度
    protected RefinedAbstractTea(Size size) {
        super(size);
    }

    public String getSize(){   //添加尺寸维度获取方式
        return size.getSize();
    }
}
class Large implements Size{

    @Override
    public String getSize() {
        return "大杯";
    }
}

class Small implements Size{
    @Override
    public String getSize() {
        return "小杯";
    }
}

class KissTea extends RefinedAbstractTea{   //创建一个啵啵芋圆奶茶的子类
    protected KissTea(Size size) {   //在构造时需要指定具体的大小实现
        super(size);
    }

    @Override
    public String getType() {
        return "啵啵芋圆奶茶";   //返回奶茶类型
    }
}
