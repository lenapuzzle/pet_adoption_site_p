package com.launchacademy.petadoption.seeders;

import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder {
  private final PetTypeService petTypeService;

  @Autowired
  public PetTypeSeeder(PetTypeService petTypeService) {
    this.petTypeService = petTypeService;
  }

  public void run(String... args) throws Exception {

    if(petTypeService.findAll().size() == 0) {
      PetType dog = new PetType();
      dog.setName("Dog");
      dog.setImgUrl("https://images.unsplash.com/photo-1601758124277-f0086d5ab050?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1052&q=80");
      dog.setDescription("Man's Best Friend");
      petTypeService.save(dog);

      PetType cat = new PetType();
      cat.setName("Cat");
      cat.setImgUrl("https://images.unsplash.com/photo-1495360010541-f48722b34f7d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=752&q=80");
      cat.setDescription("Cat's Best Friend");
      petTypeService.save(cat);

      PetType fish = new PetType();
      fish.setName("Fish");
      fish.setImgUrl("https://images.unsplash.com/photo-1535591273668-578e31182c4f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80");
      fish.setDescription("Your Silent and Serene Friend");
      petTypeService.save(fish);
    }
  }
}
