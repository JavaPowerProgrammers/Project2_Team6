package com.ex.controllers;

import com.ex.pojos.Dagger;
import com.ex.services.DaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DaggerController {

    private DaggerService service;

    public DaggerController() {
    }

    @Autowired
    public DaggerController(DaggerService daggerService) {
        this.service = daggerService;
    }

    //    @GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Daggers")
    public @ResponseBody ResponseEntity getAllDaggers(){
        List<Dagger> daggers = service.getAllDaggers();

        return new ResponseEntity(daggers, HttpStatus.OK);
    }
}