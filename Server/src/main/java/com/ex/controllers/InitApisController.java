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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/dndApiData")
    public @ResponseBody
    ResponseEntity getAllApiData(){
        //David fill in images and statbuffs
        List<List<String>> data = Arrays.asList(Arrays.asList("Acid Arrow", "./res/imgs/spells/acidarrow.png", "spell", "Intelligence"),
                Arrays.asList("Dagger", "./res/imgs/weapons/dagger.png", "weapon", "Dexterity"),
                Arrays.asList("Dancing Lights", "./res/imgs/spells/dancinglights2.jpg", "spell", "Intelligence"),
                Arrays.asList("Burning Hands", "./res/imgs/spells/Burning_hands.webp", "spell", "Intelligence"),
                Arrays.asList("Crossbow, heavy", "./res/imgs/weapons/crossbow2.png", "weapon", "Dexterity"),
                Arrays.asList("Potion of healing", "./res/gifs/potions/healingpotion.gif", "spell", "Intelligence"),
                Arrays.asList("Magic Missile", "./res/gifs/spells/magic missile.gif", "spell", "Intelligence"),
                Arrays.asList("Maul", "./res/imgs/weapons/maul.png", "weapon", "Strength"),
                Arrays.asList("Longsword", "./res/imgs/weapons/longsword.png", "weapon", "Strength"),
                Arrays.asList("Mace", "./res/imgs/weapons/mace.png", "weapon", "Strength"));
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
