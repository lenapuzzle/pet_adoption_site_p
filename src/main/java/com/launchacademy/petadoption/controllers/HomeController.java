package com.launchacademy.petadoption.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/pet-types", "/pet-types/{id}", "/pets/{id}", "/pets/{id}/adoption-applications", "/pets/new"})
    public String forward() {
        return "forward:/";
    }
}