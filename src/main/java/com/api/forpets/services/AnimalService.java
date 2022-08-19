package com.api.forpets.services;

import com.api.forpets.models.AnimalModel;
import com.api.forpets.models.AnimalSpecieEnum;
import com.api.forpets.repositories.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;


@Service
public class AnimalService {
    final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public AnimalModel addAnimal(AnimalModel animal) {
        if (isNull(animal.getBreed())){
            animal.setBreed("Unknown");
        }
        if (isNull(animal.getName())){
            animal.setName("No name");
        }
        return animalRepository.save(animal);
    }

    @Transactional(readOnly = true)
    public List<AnimalModel> getAllAnimals() {
        return animalRepository.findAll();
    }

    public List<AnimalModel> findBySpecie(String specie) {
        return animalRepository.findBySpecie(AnimalSpecieEnum.valueOf(specie));
    }

    public List<AnimalModel> findByWeight(double min, double max) {
        return animalRepository.findByWeightIsBetween(min, max);
    }

    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}