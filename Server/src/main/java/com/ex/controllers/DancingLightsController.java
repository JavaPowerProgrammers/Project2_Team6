package com.ex.controllers;

import com.ex.pojos.DancingLights;
import com.ex.services.DancingLightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DancingLightsController {

    private DancingLightsService service;

    public DancingLightsController() {
    }

    @Autowired
    public DancingLightsController(DancingLightsService dancingLightsService) {
        this.service = dancingLightsService;
    }

    //    @GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/DancingLights")
    public @ResponseBody ResponseEntity getAllDancingLights(){
        List<DancingLights> dancingLights = service.getAllDancingLights();

        return new ResponseEntity(dancingLights, HttpStatus.OK);
    }
}