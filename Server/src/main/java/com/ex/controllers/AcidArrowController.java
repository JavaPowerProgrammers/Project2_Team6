package com.ex.controllers;

import com.ex.pojos.AcidArrow;
import com.ex.services.AcidArrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcidArrowController {

    private AcidArrowService service;

    public AcidArrowController() {
    }

    @Autowired
    public AcidArrowController(AcidArrowService acidArrowService) {
        this.service = acidArrowService;
    }

    //    @GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/AcidArrows")
    public @ResponseBody ResponseEntity getAllAcidArrows(){
        List<AcidArrow> acidArrows = service.getAllAcidArrows();

        return new ResponseEntity(acidArrows, HttpStatus.OK);
    }
}