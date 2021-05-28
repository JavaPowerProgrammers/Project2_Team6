package com.ex.controllers;

import com.ex.pojos.player.DnDClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class InitApisController {


    public InitApisController() {
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/dndApiData")
    public @ResponseBody
    ResponseEntity getAllApiData(){
        //David fill in images and statbuffs
        List<List<String>> data = Arrays.asList(Arrays.asList("acid-arrow", "./res/imgs/spells/acidarrow.png", "spell", "Intelligence"),
                Arrays.asList("dagger", "./res/imgs/weapons/dagger.png", "weapon", "Dexterity"),
                Arrays.asList("dancing-lights", "./res/imgs/spells/dancinglights2.jpg", "spell", "Intelligence"),
                Arrays.asList("burning-hands", "./res/imgs/spells/Burning_hands.webp", "spell", "Intelligence"),
                Arrays.asList("crossbow-heavy", "./res/imgs/weapons/crossbow2.png", "weapon", "Dexterity"),
                Arrays.asList("potion-of-healing", "./res/gifs/potions/healingpotion.gif", "spell", "Intelligence"),
                Arrays.asList("magic-missile", "./res/gifs/spells/magic missile.gif", "spell", "Intelligence"),
                Arrays.asList("maul", "./res/imgs/weapons/maul.png", "weapon", "Strength"),
                Arrays.asList("longsword", "./res/imgs/weapons/longsword.png", "weapon", "Strength"),
                Arrays.asList("mace", "./res/imgs/weapons/mace.png", "weapon", "Strength"));
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
