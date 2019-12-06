package com.adaming.vaugrenier.rest;

import com.adaming.vaugrenier.dto.UserDto;
import com.adaming.vaugrenier.entity.User;
import com.adaming.vaugrenier.exception.UserAlreadyExistException;
import com.adaming.vaugrenier.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRest {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(path = "/users/experts",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    public List<UserDto> displayExpertMails(){
        List<UserDto> userDtos=userService.getAllExperts();
        return userDtos;
    }

    @PostMapping(path = "/users/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto newUser(@RequestBody User user){
        try {
            userService.register(user.getPseudo(), user.getPassword(), user.getEmail());
        } catch (UserAlreadyExistException e){
            e.printStackTrace();
        }
        return user.toDto();
    }
}
