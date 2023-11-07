package com.结构型.Proxy_代理模式;

class Proxy {
    public static void main(String[] args) {
        new SubjectProxy(new SubjectImpl()).doWork();
    }
}

// 目标类
interface Subject {
    void doWork();
}


// 目标类对象
class SubjectImpl implements Subject{
    @Override
    public void doWork() {
        System.out.println("工作");
    }
}

class SubjectProxy implements Subject{ //此类无法直接使用，需要我们进行代理

    // 传入目标类对象
    private SubjectImpl subject;

    public SubjectProxy(SubjectImpl subject){
        this.subject = subject;
    }

    // 代理类中添加方法
    public void connect(){
        System.out.println("建立连接");
    }

    public void log(){
        System.out.println("打印日志");
    }

    @Override
    public void doWork() {
        connect();
        subject.doWork();
        log();
    }
}

