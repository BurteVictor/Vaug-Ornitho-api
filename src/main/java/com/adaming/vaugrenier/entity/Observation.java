package com.adaming.vaugrenier.entity;

import com.adaming.vaugrenier.dto.ObservationDto;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private String day;
    private int observationCounter;
    private String month;
    private String year;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "observation_dates",
            joinColumns = @JoinColumn(name = "observation_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dates_id",referencedColumnName = "id")
    )
    private List<Dates> dates;

    public Observation(){
        this.observationCounter=1;
    }
    public Observation(String genre,String species,String vulgarName,String description,String day, String month, String year){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.description=description;
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public Observation(String genre, String species, String vulgarName, String imageUrl, String description, List<Dates> dates) {
        this.observationCounter=1;
        this.genre = genre;
        this.species = species;
        this.vulgarName = vulgarName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.dates = dates;
    }

    public Observation(String genre, String species, String vulgarName, String description){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.description=description;
    }
    public Observation(String genre,String species,String vulgarName,String imageUrl,String description,String day, String month, String year){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.imageUrl=imageUrl;
        this.description=description;
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public Observation(String genre,String species,String vulgarName,String imageUrl,String description){
        this.observationCounter=1;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.imageUrl=imageUrl;
        this.description=description;
    }
    public Observation(Long id, String genre,String species,String vulgarName,String imageUrl,String description,String day, String month, String year){
        this.id=id;
        this.genre=genre;
        this.species=species;
        this.vulgarName=vulgarName;
        this.imageUrl=imageUrl;
        this.description=description;
        this.day=day;
        this.month=month;
        this.year=year;
        this.observationCounter=1;
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
        Observation observation=new Observation(this.id,this.genre,this.species,this.vulgarName,this.imageUrl,this.description,this.day,this.month,this.year);
        return new ObservationDto(observation.getId(),observation.getGenre(),observation.getSpecies(),observation.getVulgarName(),observation.getImageUrl(),observation.getDescription(),observation.getDates());
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
}
