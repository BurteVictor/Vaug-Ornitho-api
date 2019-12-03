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
    private String vulgarName;
    private String imageUrl;
    private String description;
    private Date date;
    private int observationCounter;

    public Observation(){
        this.observationCounter=1;
    }
    public Observation(String genre,String species,String vulgarName,String description){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.description=description;
    }
    public Observation(String genre,String species,String vulgarName,String imageUrl,String description){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.imageUrl=imageUrl;
        this.description=description;
    }
    public Observation(Long id, String genre,String species,String vulgarName,String imageUrl,String description){
        this.id=id;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.imageUrl=imageUrl;
        this.description=description;
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

    public String getVulgarName() {
        return vulgarName;
    }

    public void setVulgarName(String vulgarName) {
        this.vulgarName = vulgarName;
    }

    public void setObservationCounter(int observationCounter) {
        this.observationCounter = observationCounter;
    }

    public ObservationDto toDto(){
        Observation observation=new Observation(this.id,this.genre,this.species,this.vulgarName,this.imageUrl,this.description);
        return new ObservationDto(observation.getId(),observation.getGenre(),observation.getSpecies(),observation.getVulgarName(),observation.getImageUrl(),observation.getDescription());
    }
}
