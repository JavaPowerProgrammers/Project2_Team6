package com.ex.controllers;

import com.ex.pojos.BurningHands;
import com.ex.services.BurningHandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BurningHandsController {

    private BurningHandsService service;

    public BurningHandsController() {
    }

    @Autowired
    public BurningHandsController(BurningHandsService burningHandsService) {
        this.service = burningHandsService;
    }

    //    @GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/BurningHands")
    public @ResponseBody ResponseEntity getAllBurningHands(){
        List<BurningHands> burningHands = service.getAllBurningHands();

        return new ResponseEntity(burningHands, HttpStatus.OK);
    }
}