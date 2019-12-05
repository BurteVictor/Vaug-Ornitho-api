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
    public ObservationDto getSpecificObsDto(Long id) {
        Observation observation=observationRepository.getObservationById(id);
        return observation.toDto();
    }
    @Override
    public Observation getSpecificObs(Long id) {
        Observation observation=observationRepository.getObservationById(id);
        return observation;
    }
    @Override
    public ObservationDto getSpecificObs(String vulgarName) {
        Observation observation=observationRepository.getObservationByVulgarName(vulgarName);
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
    public void createObservation(String genre, String species,String vulgarName, String description) {
        Observation observationToAdd=new Observation(genre,species,vulgarName,description);
        observationRepository.save(observationToAdd);
    }

    @Override
    public void createObservation(String genre, String species, String vulgarName, String imageUrl, String description) {
        imageUrl = "http://localhost:8080/api/uploads/" + imageUrl;
        Observation observationToAdd=new Observation(genre,species,vulgarName,imageUrl,description);
        observationRepository.save(observationToAdd);
    }

    @Override
    public void addCounterObs(Observation observation) {
        Observation observationTotest=observationRepository.getObservationById(observation.getId());
        if(observationTotest==null){
            Observation newObs= new Observation(observation.getGenre(),observation.getSpecies(),observation.getImageUrl(),observation.getDescription());
            observationRepository.save(newObs);
        } else {
            observation.setObservationCounter(observation.getObservationCounter()+1);
            observationRepository.save(observation);
        }
    }

    @Override
    public void deleteObsById(Long id) {
        Observation observationToDelete=observationRepository.getObservationById(id);
        if(observationToDelete!=null){
            observationRepository.delete(observationToDelete);
        }
    }
}
