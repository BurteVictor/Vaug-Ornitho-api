package com.adaming.vaugrenier.dto;

public class UserDto {
    private Long id;
    private String pseudo;
    private String email;

    public UserDto(){
    }
    public UserDto(Long id, String pseudo, String email){
        this.id=id;
        this.pseudo=pseudo;
        this.email=email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
