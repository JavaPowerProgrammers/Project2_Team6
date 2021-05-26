package com.ex.controllers;

import com.ex.pojos.player.Species;
import com.ex.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpeciesController {

    private SpeciesService service;

    public SpeciesController() {
    }

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.service = speciesService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Species")
    public @ResponseBody ResponseEntity getAllSpecies(){
        List<Species> species = service.getAllSpecies();
        return new ResponseEntity(species, HttpStatus.OK);
    }
}