package com.adaming.vaugrenier.entity;


import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;
    private String description;

    public Role(){}
    public Role(RoleNameEnum roleNameEnum, String description){
        this.name=roleNameEnum;
        this.description=description;
    }

    public String getAuthority() {
        return name.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
