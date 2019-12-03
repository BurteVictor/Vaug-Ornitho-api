package com.adaming.vaugrenier.service.user;

import com.adaming.vaugrenier.dto.UserDto;
import com.adaming.vaugrenier.entity.Role;
import com.adaming.vaugrenier.entity.RoleNameEnum;
import com.adaming.vaugrenier.entity.User;
import com.adaming.vaugrenier.exception.UserAlreadyExistException;
import com.adaming.vaugrenier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void register(String pseudo, String password, String email) throws UserAlreadyExistException {
        User userTotest=userRepository.getUserByEmail(email);
        if(userTotest==null){
            List<Role> defaultRole=new ArrayList<>();
            Role simpleUser=new Role(RoleNameEnum.USER,"simple user");
            defaultRole.add(simpleUser);
            User userToAdd=new User(pseudo,password,email, defaultRole);
            userRepository.save(userToAdd);
        } else {
            throw new UserAlreadyExistException(email);
        }
    }
    @Override
    public void register(String pseudo, String password, String email, List<Role> role) throws UserAlreadyExistException {
        User userTotest=userRepository.getUserByEmail(email);
        if(userTotest==null){
            User userToAdd=new User(pseudo,password,email, role);
            userRepository.save(userToAdd);
        } else {
            throw new UserAlreadyExistException(email);
        }
    }

    @Override
    public void remove(User user) {
    userRepository.delete(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String expertContact(String pseudo) {
        String emailToReturn= pseudo + " is not an expert";
        User expertToFind = userRepository.getUserByPseudo(pseudo);
        if (expertToFind.getRole().size()>1){
            emailToReturn=expertToFind.getEmail();
        }
        return emailToReturn;
    }

    @Override
    public List<UserDto> getAllExperts() {
        List<User> userList= (List<User>) userRepository.findAll();
        List<UserDto> userDtos =new ArrayList<>();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getRole().size()>1){
                userDtos.add(userList.get(i).toDto());
            }
        }
        return userDtos;
    }
}
