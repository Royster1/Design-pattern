package com.结构型.Flyweight_享元模式;

public class UserService { //用户服务
    public static void main(String[] args) {
        // 需要使用享元对象时，直接找享元工厂
        DBUtil util = DBUtilFactory.getFlyweight();   // 通过享元工厂拿到DBUtil对象
        util.selectDB();    //该干嘛干嘛
    }
}

// 数据库工具类
class DBUtil {
    public void selectDB(){
        System.out.println("我是数据库操作...");
    }
}


// 享元工厂
class DBUtilFactory {
    private static final DBUtil UTIL = new DBUtil();   //享元对象被存放在工厂中
    public static DBUtil getFlyweight(){   //获取享元 对象
        return UTIL;
    }
}