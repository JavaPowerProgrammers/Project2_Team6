package com.ex.controllers;

import com.ex.pojos.Creature;
import com.ex.services.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreatureController {

    private CreatureService service;

    public CreatureController() {
    }

    @Autowired
    public CreatureController(CreatureService creatureService) {
        this.service = creatureService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Creatures")
    public @ResponseBody ResponseEntity getAllCreatures(){
        List<Creature> creatures = service.getAllCreatures();
        return new ResponseEntity(creatures, HttpStatus.OK);
    }
}