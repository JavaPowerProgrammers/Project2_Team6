package com.ex.controllers;

import com.ex.pojos.items.Key;
import com.ex.services.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyController {

    private KeyService service;

    public KeyController() {
    }

    @Autowired
    public KeyController(KeyService keyService) {
        this.service = keyService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Keys")
    public @ResponseBody ResponseEntity getAllKeys(){
        List<Key> keys = service.getAllKeys();
        return new ResponseEntity(keys.get(0), HttpStatus.OK);
    }
}