package com.adaming.vaugrenier.repository;

import com.adaming.vaugrenier.entity.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends CrudRepository<Observation,Long> {
    Observation getObservationById(Long id);
    Observation getObservationByVulgarName(String vulgarName);
    Observation getObservationBySpecies(String species);
}
