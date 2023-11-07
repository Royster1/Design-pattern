package com.结构型.Proxy_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class JDK_Proxy {
    public static void main(String[] args) {
        SubjectTestImpl subjectTest = new SubjectTestImpl(); // 被代理的对象 也就是目标类对象
        InvocationHandler handler = new ProxyTest(subjectTest);
        SubjectTest Proxy = (SubjectTest) java.lang.reflect.Proxy.newProxyInstance(
                subjectTest.getClass().getClassLoader(),    //需要传入被代理的类的类加载器
                subjectTest.getClass().getInterfaces(),    //需要传入被代理的类的接口列表
                handler);    //最后传入我们实现的代理处理逻辑实现类
        Proxy.doWork();    //比如现在我们调用代理类的test方法，那么就会进入到我们上面TestProxy中invoke方法，走我们的代理逻辑
    }
}

// 目标类
interface SubjectTest {  //JDK提供的动态代理只支持  接口
    void doWork();
}

// 目标类对象
class SubjectTestImpl implements SubjectTest{

    @Override
    public void doWork() {
        System.out.println("这是目标类对象, 工作!");
    }
}

// 代理类
class ProxyTest implements InvocationHandler {  //代理类，需要实现InvocationHandler接口

    // 保存代理类对象
    private SubjectTestImpl subjectTest;

    // 代理类对象构造方法
    public ProxyTest(SubjectTestImpl subjectTest){
        this.subjectTest = subjectTest;
    }

    @Override //此方法就是调用代理对象的对应方法时会进入，这里我们就需要编写如何进行代理了
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method就是调用的代理对象的哪一个方法，args是实参数组
        System.out.println("代理的对象："+proxy.getClass());   //proxy就是生成的代理对象了，我们看看是什么类型的
        Object res = method.invoke(subjectTest, args);   //在代理中调用被代理对象原本的方法，因为你是代理，还是得执行一下别人的业务，当然也可以不执行，但是这样就失去代理的意义了，注意要用上面的object
        System.out.println("方法调用完成，返回值为："+res);   //看看返回值是什么
        return res;   //返回返回值
    }
}