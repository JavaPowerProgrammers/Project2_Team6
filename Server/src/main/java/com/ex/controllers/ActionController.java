package com.ex.controllers;

import com.ex.pojos.Action;
import com.ex.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActionController {

    private ActionService service;

    public ActionController() {
    }

    @Autowired
    public ActionController(ActionService actionService) {
        this.service = actionService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Actions")
    public @ResponseBody ResponseEntity getAllActions(){
        List<Action> actions = service.getAllActions();
        return new ResponseEntity(actions, HttpStatus.OK);
    }
}