package com.ex.controllers;

import com.ex.pojos.items.Spell;
import com.ex.services.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpellController {

    private SpellService service;

    public SpellController() {
    }

    @Autowired
    public SpellController(SpellService spellService) {
        this.service = spellService;
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Spells")
    public @ResponseBody ResponseEntity getAllSpells(){
        List<Spell> spells = service.getAllSpells();
        return new ResponseEntity(spells, HttpStatus.OK);
    }
}