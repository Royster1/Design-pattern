package com.设计原则.依赖倒转原则;

import javax.annotation.Resource;

public class Main {

    public static void main(String[] args) {
        UserController controller = new UserController();
    }

    interface UserMapper {
        //接口中只做CRUD方法定义
    }

    static class UserMapperImpl implements UserMapper {
        //实现类完成CRUD具体实现 Mybatis实现
    }

    interface UserService {
        //业务代码定义....
    }

    static class UserServiceImpl implements UserService {
        @Resource   //现在由Spring来为我们选择一个指定的实现类，然后注入，而不是由我们在类中硬编码进行指定
        UserMapper mapper;

        //业务代码具体实现
    }

    static class UserController {
        @Resource
        UserService service;   //直接使用接口，就算你改实现，我也不需要再修改代码了

        //业务代码....
    }
}