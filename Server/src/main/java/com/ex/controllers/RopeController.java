package com.ex.controllers;

import com.ex.pojos.items.Rope;
import com.ex.services.RopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RopeController {

    private RopeService service;

    public RopeController() {
    }

    @Autowired
    public RopeController(RopeService ropeService) {
        this.service = ropeService;
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Ropes")
    public @ResponseBody ResponseEntity getAllRopes(){
        List<Rope> ropes = service.getAllRopes();
        return new ResponseEntity(ropes.get(0), HttpStatus.OK);
    }
}