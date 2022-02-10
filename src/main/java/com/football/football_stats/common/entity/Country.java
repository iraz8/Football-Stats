package com.football.football_stats.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Country")

public class Country {

    @Id
    @Column(name = "name_en", unique = true)
    private String name_en;

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
}
