package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRestRepository extends PagingAndSortingRepository<Pet, Integer> {

  public List<Pet> findByPetTypeAndAvailableForAdoption(PetType petType, Boolean availableForAdoption);
}
