package com.设计原则.开闭原则;

public abstract class Coder {

    public abstract void coding();

    class JavaCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("Java太卷了T_T，快去学Go吧！");
        }
    }

    class PHPCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("PHP是世界上最好的语言");
        }
    }

    class C艹Coder extends Coder{
        @Override
        public void coding() {
            System.out.println("笑死，Java再牛逼底层不还得找我？");
        }
    }
}