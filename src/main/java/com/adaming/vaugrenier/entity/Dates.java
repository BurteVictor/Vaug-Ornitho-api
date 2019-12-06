package com.adaming.vaugrenier.entity;

import com.adaming.vaugrenier.dto.DatesDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dates")
public class Dates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String day;
    private String month;
    private String year;

    public Dates(){}

    public Dates(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
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
    public DatesDto toDto() {
        DatesDto datesDto=new DatesDto(this.getDay(),this.getMonth(),this.getYear());
        return datesDto;
    }
}
