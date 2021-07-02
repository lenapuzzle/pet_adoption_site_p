package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.AdoptionApplication;
import com.launchacademy.petadoption.repositories.AdoptionAppRestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionAppService {
  private final AdoptionAppRestRepository adoptionAppRestRepository;

  @Autowired
  public AdoptionAppService(AdoptionAppRestRepository adoptionAppRestRepository) {
    this.adoptionAppRestRepository = adoptionAppRestRepository;
  }

  public AdoptionApplication save(AdoptionApplication adoptionApp) {
    return adoptionAppRestRepository.save(adoptionApp);
  }

  public List<AdoptionApplication> findAll() {
    return (List<AdoptionApplication>) adoptionAppRestRepository.findAll();
  }
}
