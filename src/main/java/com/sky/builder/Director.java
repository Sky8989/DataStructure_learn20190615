package com.sky.builder;

/**
 * 指挥者
 */
public class Director {

    /**
     * 建造角色
     * @param builder
     * @return
     */
    public Role construct(Builder builder){
        builder.buildHead();
        builder.buildBody();
        builder.buildHand();
        builder.buildFoot();
        builder.buildHp();
        builder.buildMp();
        builder.buildSp();
        return builder.getRole();
    }
}
