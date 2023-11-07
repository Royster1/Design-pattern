package com.设计模式.建造者模式;

import java.nio.file.FileStore;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 使用构建器来创建电脑对象
        Computer computer = new ComputerBuilder()
                .setCpu("Intel i7")
                .setMemory("8GB")
                .setStorage("1TB")
                .build();

        // 输出电脑信息
        System.out.println(computer.toString());
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String storage;

    public Computer() {
        // 默认构造函数
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", memory=" + memory + ", storage=" + storage + "]";
    }
}

class ComputerBuilder {
    private Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setMemory(String memory) {
        computer.setMemory(memory);
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public Computer build() {
        return computer;
    }
}