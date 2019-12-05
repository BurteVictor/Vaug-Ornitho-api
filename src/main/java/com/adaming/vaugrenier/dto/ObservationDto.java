package com.adaming.vaugrenier.dto;

import org.springframework.web.multipart.MultipartFile;

public class ObservationDto {
    private Long id;
    private String genre;
    private String species;
    private String vulgarName;
    private String imageUrl;
    private String description;
    private int observationCounter;
    private MultipartFile file;


    public ObservationDto(){}

    public ObservationDto(String genre, String species, String vulgarName,String imageUrl, String description) {
        this.observationCounter=1;
        this.genre = genre;
        this.species = species;
        this.vulgarName=vulgarName;
        this.imageUrl = imageUrl;
        this.description = description;
    }
    public ObservationDto(String genre, String species, String vulgarName, String description, MultipartFile file) {
        this.observationCounter=1;
        this.genre = genre;
        this.species = species;
        this.vulgarName=vulgarName;
        this.file = file;
        this.description = description;
    }
    public ObservationDto(Long id, String genre, String species, String vulgarName, String imageUrl, String description) {
        this.observationCounter=1;
        this.id = id;
        this.genre = genre;
        this.species = species;
        this.vulgarName=vulgarName;
        this.imageUrl = imageUrl;
        this.description = description;
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

    public int getObservationCounter() {
        return observationCounter;
    }

    public void setObservationCounter(int observationCounter) {
        this.observationCounter = observationCounter;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
