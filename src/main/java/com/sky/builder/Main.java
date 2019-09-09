package com.sky.builder;

/**
 * 测试类
 */
public class Main {

    public static void main(String[] args) {
        //指挥者
        Director director = new Director();
        //普通建造者
        Builder commonBuilder = new CommonRoleBuilder();
        //VIP建造者
        Builder vipBuilder = new VIPRoleBuilder();

        //客户说 创建普遍角色
        director.construct(commonBuilder);

        //客户说 创建VIP角色
        director.construct(vipBuilder);

        System.out.println("普通角色 = "+commonBuilder.getRole());
        System.out.println("VIP角色 = " + vipBuilder.getRole());




    }
}
