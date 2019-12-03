package com.adaming.vaugrenier.service.user;

import com.adaming.vaugrenier.entity.Role;
import com.adaming.vaugrenier.entity.User;
import com.adaming.vaugrenier.exception.UserAlreadyExistException;
import com.adaming.vaugrenier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

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
}
