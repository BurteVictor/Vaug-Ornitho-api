package com.adaming.vaugrenier.service.observation;

import com.adaming.vaugrenier.dto.ObservationDto;
import com.adaming.vaugrenier.entity.Dates;
import com.adaming.vaugrenier.entity.Observation;


import java.util.List;

public interface ObservationService {
    ObservationDto getSpecificObsDto(Long id);
    Observation getSpecificObs(Long id);
    ObservationDto getSpecificObs(String vulgarName);
    List<ObservationDto> getAllObs();
    void createObservation(String genre,String species,String vulgarName,String description);
    void createObservation(String genre,String species,String vulgarName,String description,String imageUrl);
    void createObservation(String genre,String species,String vulgarName,String description,String imageUrl, String day,String month, String year);
    void addCounterObs(Observation observation);
    void deleteObsById(Long id);
    List<Dates> getAllDates(Long id);
    void addDate(String day,String month,String year, Long id);
}
