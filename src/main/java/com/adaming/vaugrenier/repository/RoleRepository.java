package com.adaming.vaugrenier.repository;

import com.adaming.vaugrenier.entity.Role;
import com.adaming.vaugrenier.entity.RoleNameEnum;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(RoleNameEnum roleName);
}
