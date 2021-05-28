package com.ex.controllers;

import com.ex.pojos.player.DnDClass;
import com.ex.services.DnDClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DnDClassController {

    private DnDClassService service;

    public DnDClassController() {
    }

    @Autowired
    public DnDClassController(DnDClassService dnDClassService) {
        this.service = dnDClassService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/DnDClasses")
    public @ResponseBody ResponseEntity getAllDnDClasses(){
        List<DnDClass> dnDClasses = service.getAllDnDClasses();
        return new ResponseEntity(dnDClasses, HttpStatus.OK);
    }
}