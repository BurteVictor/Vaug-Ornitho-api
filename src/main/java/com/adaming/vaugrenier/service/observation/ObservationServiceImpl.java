package com.adaming.vaugrenier.service.observation;

import com.adaming.vaugrenier.dto.ObservationDto;
import com.adaming.vaugrenier.entity.Observation;
import com.adaming.vaugrenier.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationServiceImpl implements ObservationService {
    @Autowired
    ObservationRepository observationRepository;

    @Override
    public ObservationDto getSpecificObs(Long id) {
        Observation observation=observationRepository.getObservationById(id);
        return observation.toDto();
    }

    @Override
    public List<ObservationDto> getAllObs() {
        List<ObservationDto> dtoList=new ArrayList<>();
        List<Observation> observations =(List<Observation>) observationRepository.findAll();
        for(int i=0;i<observations.size();i++){
            dtoList.add(observations.get(i).toDto());
        }
        return dtoList;
    }

    @Override
    public void createObservation(String genre, String species, String description) {
        Observation observationToAdd=new Observation(genre,species,description);
        observationRepository.save(observationToAdd);
    }

    @Override
    public void createObservation(String genre, String species, String description, String imageUrl) {
        imageUrl = "http://localhost:8080/api/uploads/" + imageUrl;
        Observation observationToAdd=new Observation(genre,species,imageUrl,description);
        observationRepository.save(observationToAdd);
    }
}
