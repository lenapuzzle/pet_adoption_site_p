package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetTypeRestRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetTypeService {
private final PetTypeRestRepository petTypeRestRepository;

  @Autowired
  public PetTypeService(PetTypeRestRepository petTypeRestRepository) {
    this.petTypeRestRepository = petTypeRestRepository;
  }

  public List<PetType> findAll() {
    return (List<PetType>) petTypeRestRepository.findAll();
  }

  public PetType save(PetType petType) {
    return petTypeRestRepository.save(petType);
  }

  public Optional<PetType> findById(Integer id) {
    return petTypeRestRepository.findById(id);
  }

  public PetType findByName(String name) {
    return petTypeRestRepository.findByName(name);
  }
}
