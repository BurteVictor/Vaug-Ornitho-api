package com.adaming.vaugrenier.repository;

import com.adaming.vaugrenier.entity.Dates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesRepository extends CrudRepository<Dates,Long> {
    Dates getDatesById(Long id);
}
