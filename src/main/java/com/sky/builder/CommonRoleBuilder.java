package com.sky.builder;

/**
 * 具体建造者  普通 角色建造者
 */
public class CommonRoleBuilder extends Builder {
    @Override
    public void buildHead() {
        role.setHead("common head");
    }
    @Override
    public void buildBody() {
        role.setBody("common body");
    }
    @Override
    public void buildHand() {
        role.setHand("common hand");
    }
    @Override
    public void buildFoot() {
        role.setFoot("common foot");
    }
    @Override
    public void buildHp() {
        role.setHp(100.0d);
    }
    @Override
    public void buildSp() {
        role.setSp(100.0d);
    }
    @Override
    public void buildMp() {
        role.setMp(100.0d);
    }
}
