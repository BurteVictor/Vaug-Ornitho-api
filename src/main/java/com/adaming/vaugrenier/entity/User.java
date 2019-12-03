package com.adaming.vaugrenier.entity;

import com.adaming.vaugrenier.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private List<Role> role;

    public User(){}
    public User(Long id, String pseudo, String email){
        this.id=id;
        this.pseudo=pseudo;
        this.email=email;
    }
    public User(Long id, String pseudo, String email, List<Role> role){
        this.id=id;
        this.pseudo=pseudo;
        this.email=email;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto toDto(){
        User user=new User(this.id,this.pseudo,this.email);
        return new UserDto(user.getId(),user.getPseudo(),user.getEmail());
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
