package com.结构型.Adapter_Design_适配器模式;

public class Adapter_Design {
    public static void main(String[] args) {
        System.out.println(new Adapter(new Speaker()).translate());
    }
}

class Speaker{
    public String speak(){
        return "这是我要说的话";
    }
}

// 翻译-适配器
interface Translator{
    public String translate();
}

// 接受者 实现适配器
class Adapter implements Translator{

    // 传入发送者对象
    private Speaker speaker;
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        // 理解手语,翻译,通过适配器理解到该内容
        return result;
    }
}


