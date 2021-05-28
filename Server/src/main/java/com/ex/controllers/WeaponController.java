package com.ex.controllers;

import com.ex.pojos.items.Weapon;
import com.ex.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeaponController {

    private WeaponService service;

    public WeaponController() {
    }

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.service = weaponService;
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Weapons")
    public @ResponseBody ResponseEntity getAllWeapons(){
        List<Weapon> weapons = service.getAllWeapons();
        return new ResponseEntity(weapons, HttpStatus.OK);
    }
}