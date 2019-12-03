package com.adaming.vaugrenier.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String email){
            super("Cet utilisateur est existe déjà");
    }
}
