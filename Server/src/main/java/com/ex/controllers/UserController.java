package com.ex.controllers;

import com.ex.pojos.User;
import com.ex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/hello-world")
public class UserController {

    private UserService service;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Users")
    public @ResponseBody ResponseEntity getAllUsers(){
        List<User> users = service.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}