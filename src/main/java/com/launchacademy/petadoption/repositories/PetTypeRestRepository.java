package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.PetType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRestRepository extends PagingAndSortingRepository<PetType, Integer> {
  public PetType findByName(String name);
}
