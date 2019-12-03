package com.adaming.vaugrenier.service.observation;

import com.adaming.vaugrenier.dto.ObservationDto;


import java.util.List;

public interface ObservationService {
    ObservationDto getSpecificObs(Long id);
    List<ObservationDto> getAllObs();
    void createObservation(String genre,String species,String description);
    void createObservation(String genre,String species,String description,String imageUrl);
}
