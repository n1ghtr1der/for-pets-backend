package com.api.forpets.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "TB_ANIMAL")
@SQLDelete(sql = "UPDATE tb_animal SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class AnimalModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 30)
    private  String breed;
    @Column(length = 20)
    private String type;
    @Column(nullable = false)
    @NotNull(message = "Weight can't be null!")
    private double weight;
    @Column(nullable = false)
    @NotBlank(message = "Image URL is necessary.")
    private String imageURL;
    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @Column(nullable = false)
    private Boolean vaccinated;
    @Column
    private boolean deleted = Boolean.FALSE;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
