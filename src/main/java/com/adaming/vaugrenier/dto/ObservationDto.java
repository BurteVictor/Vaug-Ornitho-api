package com.adaming.vaugrenier.dto;

public class ObservationDto {
    private Long id;
    private String genre;
    private String species;
    private String vulgarName;
    private String imageUrl;
    private String description;


    public ObservationDto(){}

    public ObservationDto(String genre, String species, String vulgarName,String imageUrl, String description) {
        this.genre = genre;
        this.species = species;
        this.vulgarName=vulgarName;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public ObservationDto(Long id, String genre, String species, String vulgarName, String imageUrl, String description) {
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
}
