package com.sky.builder;

/**
 *  产品角色
 */
public class NewRole {
    private String head; //头部
    private String body; //身体
    private String hand; //手
    private String foot; //脚
    private Double hp;   //生命值
    private Double sp;   //能量值
    private Double mp;   //魔法值


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getSp() {
        return sp;
    }

    public void setSp(Double sp) {
        this.sp = sp;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }


    /**
     * 私有化 无惨构造器
     */
    public void NewRole(){

    }


    /**
     * 私有构造 新角色
     * @param builder
     */
    private NewRole(Builder builder) {
        this.head = builder.head;
        this.body = builder.body;
        this.hand = builder.hand;
        this.foot = builder.foot;
        this.hp = builder.hp;
        this.sp = builder.sp;
        this.mp = builder.mp;
    }

    public static  class Builder{
        private  String head; //头部
        private  String body; //身体
        private  String hand; //手
        private  String foot; //脚
        private   Double hp;   //生命值
        private  Double sp;   //能量值
        private  Double mp;   //魔法值

        public Builder() {
        }


        public Builder head(String head){
            this.head = head;
            return this;
        }
        public Builder body(String body){
            this.body = body;
            return this;
        }
        public Builder hand(String hand){
            this.hand = hand;
            return this;
        }
        public Builder foot(String foot){
            this.foot = foot;
            return this;
        }

        public Builder hp(Double hp){
            this.hp = hp;
            return this;
        }
        public Builder sp(Double sp){
            this.sp = sp;
            return this;
        }
        public Builder mp(Double mp){
            this.mp = mp;
            return this;
        }

        /**
         * 构建对象
         * @return
         */
        public NewRole build() {
            return new NewRole(this);
        }




    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("head='").append(head).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", hand='").append(hand).append('\'');
        sb.append(", foot='").append(foot).append('\'');
        sb.append(", hp=").append(hp);
        sb.append(", sp=").append(sp);
        sb.append(", mp=").append(mp);
        sb.append('}');
        return sb.toString();
    }
}
