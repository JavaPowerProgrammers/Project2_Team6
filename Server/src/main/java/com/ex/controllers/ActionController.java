package com.ex.controllers;

import com.ex.BackendApplication;
import com.ex.pojos.Action;
import com.ex.services.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ActionController {

    private ActionService service;

    public ActionController() {
    }

    @Autowired
    public ActionController(ActionService actionService) {
        this.service = actionService;
    }

    /*
    This requests a comment of some kind. This contrller controller and interfaces
    between the service and the repository for your viewing pleasure
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Actions")
    public @ResponseBody ResponseEntity getAllActions(){
//        log.error("");
        List<Action> actions = service.getAllActions();
//        Hello h = new Hello();
//        h.
        //BackendApplication.logger.info("");
        return new ResponseEntity(actions, HttpStatus.OK);
    }
}