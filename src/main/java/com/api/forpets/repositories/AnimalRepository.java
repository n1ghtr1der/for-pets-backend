package com.api.forpets.repositories;

import com.api.forpets.models.AnimalModel;
import com.api.forpets.models.AnimalSpecieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    void deleteById(Long id);
    List<AnimalModel> findBySpecie(AnimalSpecieEnum specie);
    List<AnimalModel> findByWeightBetween(double start, double max);
    Optional<AnimalModel> findById(Long id);
}
