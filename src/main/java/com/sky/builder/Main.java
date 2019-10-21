package com.sky.builder;

/**
 * 测试类
 */
public class Main {


    public static void main(String[] args) {
        //客户说造一个德玛
        LOLRole dema =  new LOLRole.Builder()
                .head("德玛的头")
                .body("德玛的身体")
                .hand("德玛的手")
                .foot("德玛的脚")
                .hp(100.0d)
                .sp(0.0d)
                .mp(0.0d)
                .build(); //创建角色

        System.out.println("dema = " + dema);

    }







//    public static void main(String[] args) {
//        //指挥者
//        Director director = new Director();
//        //普通建造者
//        Builder commonBuilder = new CommonRoleBuilder();
//        //VIP建造者
//        Builder vipBuilder = new VIPRoleBuilder();
//
//        //客户说 创建普遍角色
//        director.construct(commonBuilder);
//
//        //客户说 创建VIP角色
//        director.construct(vipBuilder);
//
//        System.out.println("普通角色 = "+commonBuilder.getRole());
//        System.out.println("VIP角色 = " + vipBuilder.getRole());
//
//    }



}
