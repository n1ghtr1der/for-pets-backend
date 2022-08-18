package com.api.forpets.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_ANIMAL")
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 30)
    private  String breed;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private String imageURL;
    @Column
    private Date dateOfBirth;
    @Column(nullable = false)
    private Boolean vaccinated;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalGenderEnum gender;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalSpecieEnum specie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public AnimalGenderEnum getGender() {
        return gender;
    }

    public void setGender(AnimalGenderEnum gender) {
        this.gender = gender;
    }

    public AnimalSpecieEnum getSpecie() {
        return specie;
    }

    public void setSpecie(AnimalSpecieEnum specie) {
        this.specie = specie;
    }
}
