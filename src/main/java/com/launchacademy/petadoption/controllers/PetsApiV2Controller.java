package com.launchacademy.petadoption.controllers;

import com.launchacademy.petadoption.models.AdoptionApplication;
import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.services.AdoptionAppService;
import com.launchacademy.petadoption.services.PetService;
import com.launchacademy.petadoption.services.PetTypeService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsApiV2Controller {

  private final PetService petService;
  private final AdoptionAppService adoptionAppService;
  private final PetTypeService petTypeService;

  @Autowired
  public PetsApiV2Controller(PetService petService, AdoptionAppService adoptionAppService,
      PetTypeService petTypeService) {
    this.petService = petService;
    this.adoptionAppService = adoptionAppService;
    this.petTypeService = petTypeService;
  }

  @GetMapping
  public Map<String, Iterable<Pet>> petsIndex(Model model) {
    Map<String, Iterable<Pet>> allPetsByType = new HashMap<>();
    allPetsByType.put("pets", petService.findAll());
    return allPetsByType;
  }

  @GetMapping("/{id}")
  public Map<String, Optional<Pet>> getSinglePet(@PathVariable Integer id) {
    Map<String, Optional<Pet>> pet = new HashMap<>();
    pet.put("pet", petService.findById(id));
    return pet;
  }

  @PostMapping("{id}/adoption-applications")
  public ResponseEntity<AdoptionApplication> saveApplication(
      @RequestBody @Valid AdoptionApplication adoptionApp, @PathVariable int id,
      BindingResult bindingResult) {
    Optional<Pet> pet = petService.findById(id);
    if (bindingResult.hasErrors() || pet.isEmpty()) {
      return ResponseEntity.unprocessableEntity().build();
    }
    adoptionApp.setPet(pet.get());
    adoptionAppService.save(adoptionApp);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity surrenderPet(@RequestBody @Valid Pet pet, BindingResult bindingResult) {
    Optional<PetType> petType = petTypeService.findById(pet.getPetTypeId());
    if (bindingResult.hasErrors()) {
      return ResponseEntity.unprocessableEntity().build();
    }
    pet.setPetType(petType.get());
    petService.save(pet);
    Map<String, Pet> surrenderedPet = new HashMap<>();
    surrenderedPet.put("pet", pet);
    return ResponseEntity.ok(surrenderedPet);
  }
}


