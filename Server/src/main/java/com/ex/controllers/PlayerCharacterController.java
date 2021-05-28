package com.ex.controllers;

import com.ex.pojos.player.PlayerCharacter;
import com.ex.services.PlayerCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerCharacterController {

    private PlayerCharacterService service;

    public PlayerCharacterController() {
    }

    @Autowired
    public PlayerCharacterController(PlayerCharacterService playerCharacterService) {
        this.service = playerCharacterService;
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/PlayerCharacters")
    public @ResponseBody ResponseEntity getAllPlayerCharacters(){
        List<PlayerCharacter> playerCharacters = service.getAllPlayerCharacters();
        return new ResponseEntity(playerCharacters, HttpStatus.OK);
    }
}