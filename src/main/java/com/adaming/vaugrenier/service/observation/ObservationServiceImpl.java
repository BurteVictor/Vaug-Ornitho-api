package com.adaming.vaugrenier.service.observation;

import com.adaming.vaugrenier.dto.ObservationDto;
import com.adaming.vaugrenier.entity.Dates;
import com.adaming.vaugrenier.entity.Observation;
import com.adaming.vaugrenier.repository.DatesRepository;
import com.adaming.vaugrenier.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationServiceImpl implements ObservationService {
    @Autowired
    ObservationRepository observationRepository;
    @Autowired
    DatesRepository datesRepository;

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
    public void createDates(String day, String month, String year) {
        Dates dates = new Dates (day, month, year);
        datesRepository.save(dates);
    }

    @Override
    public void createObservation(String genre, String species, String vulgarName, String imageUrl, String description, List<Dates> dates) {
        imageUrl = "http://localhost:8080/api/uploads/" + imageUrl;
        Observation observationToAdd=new Observation(genre,species,vulgarName,imageUrl,description, dates);
        for(int i=0;i<dates.size();i++) {
            this.createDates(dates.get(i).getDay(),dates.get(i).getMonth(),dates.get(i).getYear());
        }
        observationRepository.save(observationToAdd);
    }
    @Override
    public void createObservation(String genre, String species, String vulgarName, String imageUrl, String description,String day,String month, String year) {
        imageUrl = "http://localhost:8080/api/uploads/" + imageUrl;
        Observation observationToAdd=new Observation(genre,species,vulgarName,imageUrl,description,day,month,year);
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

    @Override
    public List<Dates> getAllDates(Long id) {
        List<Dates> dates=new ArrayList<>();
        Observation observation=observationRepository.getObservationById(id);
        for(int i=0;i<observation.getDates().size();i++) {
            dates.add(observation.getDates().get(i));
        }
        return dates;
    }

    @Override
    public void addDate(String day, String month, String year, Long id) {
        Observation observation=observationRepository.getObservationById(id);
        Dates dateToAdd=new Dates(day,month,year);
        observation.getDates().add(dateToAdd);
        observationRepository.save(observation);
    }
}
