package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetRestRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
  private final PetRestRepository petRestRepository;

  @Autowired
  public PetService(PetRestRepository petRestRepository) {
    this.petRestRepository = petRestRepository;
  }

  public List<Pet> findAll() {
    return (List<Pet>) petRestRepository.findAll();
  }

  public Pet save(Pet pet) {
    return petRestRepository.save(pet);
  }

  public Optional<Pet> findById(Integer id) {
    return petRestRepository.findById(id);
  }

  public List<Pet> getAvailablePets(PetType petType) {
    return petRestRepository.findByPetTypeAndAvailableForAdoption(petType, true);
  }
}
