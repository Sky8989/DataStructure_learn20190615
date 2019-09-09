package com.sky.builder;

/**
 * 抽象建造者：Builder   定义创建方法
 */
public abstract class Builder {

    protected Role role = new Role();

    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildHand();

    public abstract void buildFoot();

    public abstract void buildHp();

    public abstract void buildSp();

    public abstract void buildMp();

    /**
     * 获得建造的结果
     * @return
     */
    public Role getRole() {
        return role;
    }
}
