package com.api.forpets.repositories;

import com.api.forpets.models.AnimalModel;
import com.api.forpets.models.AnimalSpecieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    void deleteByAnimalId(Long id);
    List<AnimalModel> findBySpecie(AnimalSpecieEnum specie);
    List<AnimalModel> findByWeight(double weight);
}
