package com.adaming.vaugrenier.entity;

import com.adaming.vaugrenier.dto.ObservationDto;
import org.hibernate.annotations.Generated;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "observation")
public class Observation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String genre;
    private String species;
    private String imageUrl;
    private String description;
    private Date date;
    private int observationCounter;

    public Observation(){
        this.observationCounter=1;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getSpecies() {
        return species;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public int getObservationCounter() {
        return observationCounter;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setObservationCounter(int observationCounter) {
        this.observationCounter = observationCounter;
    }

    public ObservationDto toDto(Observation observation){
        return new ObservationDto(observation.getId(),observation.getGenre(),observation.getSpecies(),observation.getImageUrl(),observation.getDescription());
    }
}
