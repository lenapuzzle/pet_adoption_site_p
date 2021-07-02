package com.launchacademy.petadoption.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  private final PetTypeSeeder petTypeSeeder;
  private final PetSeeder petSeeder;

  @Autowired
  public MainSeeder(PetTypeSeeder petTypeSeeder, PetSeeder petSeeder) {
    this.petTypeSeeder = petTypeSeeder;
    this.petSeeder = petSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    petTypeSeeder.run();
    petSeeder.run();
  }
}