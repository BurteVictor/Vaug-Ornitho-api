package com.adaming.vaugrenier.service.user;

import com.adaming.vaugrenier.dto.UserDto;
import com.adaming.vaugrenier.entity.Role;
import com.adaming.vaugrenier.entity.User;
import com.adaming.vaugrenier.exception.UserAlreadyExistException;

import java.util.List;

public interface UserService {

    void register(String pseudo, String password, String email) throws UserAlreadyExistException;
    void register(String pseudo, String password, String email, List<Role> role) throws UserAlreadyExistException;
    void remove(User user);
    void remove(Long id);
    String expertContact(String pseudo);
    List<UserDto> getAllExperts();

}
