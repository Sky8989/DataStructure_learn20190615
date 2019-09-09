package com.sky.builder;

/**
 *  VIP角色建造者
 */
public class VIPRoleBuilder extends Builder{
    @Override
    public void buildHead() {
        role.setHead("VIP head");
    }
    @Override
    public void buildBody() {
        role.setBody("VIP body");
    }
    @Override
    public void buildHand() {
        role.setHand("VIP hand");
    }
    @Override
    public void buildFoot() {
        role.setFoot("VIP foot");
    }
    @Override
    public void buildHp() {
        role.setHp(200.0d);
    }
    @Override
    public void buildSp() {
        role.setSp(200.0d);
    }
    @Override
    public void buildMp() {
        role.setMp(200.0d);
    }
}
