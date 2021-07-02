package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.AdoptionApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionAppRestRepository extends PagingAndSortingRepository<AdoptionApplication, Integer> {
}
