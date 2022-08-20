package com.api.forpets.controllers;

import com.api.forpets.models.AnimalModel;
import com.api.forpets.services.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/for-pets")
public class AnimalController {
    final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/add")
    public ResponseEntity<AnimalModel> addAnimal(@RequestBody @Valid AnimalModel animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.addAnimal(animal));
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<AnimalModel>> getAnimals() {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.getAllAnimals());
    }

    @GetMapping("/{specie}")
    public ResponseEntity<List<AnimalModel>> showBySpecie(@PathVariable(value = "specie") String specie) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.findBySpecie(specie));
    }

    @GetMapping("/weightRange")
    public ResponseEntity<List<AnimalModel>> filterByWeightRange(@RequestParam double start, @RequestParam double end) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.findByWeight(start, end));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAnimalById(@PathVariable(value = "id") Long id) {
        Optional<AnimalModel> animalModelOptional = animalService.findById(id);
        if (!animalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal ID Not Found! Try again.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(animalModelOptional.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAnimal(@PathVariable(value = "id") Long id) {
        Optional<AnimalModel> animalModelOptional = animalService.findById(id);
        if (!animalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal ID Not Found! Try again.");
        }
        animalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Animal deleted!");
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") Long id, @RequestBody @Valid AnimalModel animalModel) {
        Optional<AnimalModel> animalModelOptional = animalService.findById(id);
        if (!animalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal ID Not Found! Try again");
        }
        animalModel.setId(animalModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(animalService.addAnimal(animalModel));
    }
}
