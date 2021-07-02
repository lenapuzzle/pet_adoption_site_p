package com.launchacademy.petadoption.controllers;

import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.services.PetService;
import com.launchacademy.petadoption.services.PetTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet-types")
public class PetTypesApiV1Controller {

  private final PetTypeService petTypeService;
  private final PetService petService;

  @Autowired
  public PetTypesApiV1Controller(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @GetMapping
  public Map<String, Iterable<PetType>> petTypesIndex() {
    Map<String, Iterable<PetType>> allPetTypes = new HashMap<>();
    allPetTypes.put("petTypes", petTypeService.findAll());
    return allPetTypes;
  }

  @GetMapping("/{id}")
  public Map<String, PetType> getSinglePet(@PathVariable Integer id) {
    Map<String, PetType> pets = new HashMap<>();
    Optional<PetType> petTypeOptional = petTypeService.findById(id);
    PetType petType = petTypeOptional.get();
    List<Pet> adoptablePets = petService.getAvailablePets(petType);
    petType.setPets(adoptablePets);
    pets.put("petType", petType);
    return pets;
  }
}


