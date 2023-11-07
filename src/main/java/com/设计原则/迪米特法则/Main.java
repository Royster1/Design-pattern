package com.设计原则.迪米特法则;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Test test = new Test();
        test.test(socket.getLocalAddress().getHostAddress());  //在外面解析好就行了, 给我字符串,别给我整个对象
    }

    static class Test {
        public void test(String str){   //一个字符串就能搞定，就没必要丢整个对象进来
            System.out.println("IP地址："+str);
        }
    }
}