package com.adaming.vaugrenier.repository;

import com.adaming.vaugrenier.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserById(Long id);
    User getUserByPseudo(String pseudo);
    User getUserByEmail(String email);
}
