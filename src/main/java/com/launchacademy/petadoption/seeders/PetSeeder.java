package com.launchacademy.petadoption.seeders;

import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.services.PetService;
import com.launchacademy.petadoption.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetSeeder {
  private final PetService petService;
  private final PetTypeService petTypeService;

  @Autowired
  public PetSeeder(PetService petService, PetTypeService petTypeService) {
    this.petService = petService;
    this.petTypeService = petTypeService;
  }

  public void run(String... args) throws Exception {
    if(petService.findAll().size() == 0) {

      PetType dog = petTypeService.findByName("Dog");
      Pet dog1 = new Pet();
      dog1.setName("Rory");
      dog1.setImgUrl("https://images.unsplash.com/photo-1576201836106-db1758fd1c97?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80");
      dog1.setAge(5);
      dog1.setVaccinationStatus(true);
      dog1.setPetType(dog);
      System.out.println(dog1.getPetType());
      petService.save(dog1);

      Pet dog2 = new Pet();
      dog2.setName("Finn");
      dog2.setImgUrl("https://images.unsplash.com/photo-1553882809-a4f57e59501d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80");
      dog2.setAge(1);
      dog2.setVaccinationStatus(false);
      dog2.setPetType(dog);
      petService.save(dog2);

      PetType cat = petTypeService.findByName("Cat");
      Pet cat1 = new Pet();
      cat1.setName("Maisy");
      cat1.setImgUrl("https://images.unsplash.com/photo-1574158622682-e40e69881006?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2000&q=80");
      cat1.setAge(3);
      cat1.setVaccinationStatus(true);
      cat1.setPetType(cat);
      petService.save(cat1);

      Pet cat2 = new Pet();
      cat2.setName("Fur Ball");
      cat2.setImgUrl("https://i.pinimg.com/originals/e8/f6/f6/e8f6f6c6653c35f506f80218f1b49d46.jpg");
      cat2.setAge(2);
      cat2.setVaccinationStatus(true);
      cat2.setPetType(cat);
      petService.save(cat2);

      PetType fish = petTypeService.findByName("Fish");
      Pet fish1 = new Pet();
      fish1.setName("Dory");
      fish1.setImgUrl("https://m.liveaquaria.com/images/articles/a-161-feed-different-food-083106-203.jpg");
      fish1.setAge(1);
      fish1.setVaccinationStatus(false);
      fish1.setPetType(fish);
      petService.save(fish1);
    }
  }
}
