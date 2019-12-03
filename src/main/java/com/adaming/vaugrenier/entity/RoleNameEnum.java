package com.adaming.vaugrenier.entity;

public enum RoleNameEnum {
    EXPERT("ROLE_EXPERT"),
    USER("ROLE_USER");

    private String value;
    RoleNameEnum(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return value;
    }
}
