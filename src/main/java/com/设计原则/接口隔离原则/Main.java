package com.设计原则.接口隔离原则;

interface SmartDevice {   //智能设备才有getCpu和getMemory
    String getCpu();
    String getType();
    String getMemory();
}

interface NormalDevice {   //普通设备只有getType
    String getType();
}

//电脑就是一种电子设备，那么我们就继承此接口
class Computer implements SmartDevice {

    @Override
    public String getCpu() {
        return "i9-12900K";
    }

    @Override
    public String getType() {
        return "电脑";
    }

    @Override
    public String getMemory() {
        return "32G DDR5";
    }
}

//电风扇也算是一种电子设备
class Fan implements NormalDevice {
    @Override
    public String getType() {
        return "风扇";
    }
}