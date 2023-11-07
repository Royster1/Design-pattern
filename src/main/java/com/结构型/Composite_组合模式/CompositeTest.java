package com.结构型.Composite_组合模式;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    public static void main(String[] args) {
        Composite china = new Composite();
        china.add(new City(1000));
        china.add(new City(2000));

        Composite shanxi = new Composite();
        shanxi.add(new City(3000));
        shanxi.add(new City(5000));

        china.add(shanxi);
        System.out.println(china.count());
    }
}


// 统计接口
interface Counter{
    int count();
}

// 叶子节点
class City implements Counter{
    private int sum = 0;

    public City(int sum){
        this.sum = sum;
    }

    @Override
    public int count() {
        return sum;
    }
}

// 容器
class Composite implements Counter{ // 计数, 新增删除功能
    private List<Counter> countersList = new ArrayList<>();

    public void add(Counter counter) {
        countersList.add(counter);
    }

    public void delete(Counter counter){
        countersList.remove(counter);
    }

    public List<Counter> getChild(){
        return countersList;
    }

    @Override
    public int count() {
        int sum = 0;
        for (Counter counter : countersList) {
            sum += counter.count();
        }
        return sum; // 求和
    }

    public void show(){
        for (Counter counter : countersList)
            System.out.println(counter.count());
    }
}