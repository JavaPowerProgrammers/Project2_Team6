package com.ex.controllers;

import com.ex.pojos.Room;
import com.ex.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private RoomService service;

    public RoomController() {
    }

    @Autowired
    public RoomController(RoomService roomService) {
        this.service = roomService;
    }
    /*
        This requests a comment of some kind. This contrller controller and interfaces
        between the service and the repository for your viewing pleasure
         */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Rooms")
    public @ResponseBody ResponseEntity getAllRooms(){
        List<Room> rooms = service.getAllRooms();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Entrance")
    public @ResponseBody ResponseEntity getEntrance(){
        return new ResponseEntity(service.findByName("Entrance"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Foyar")
    public @ResponseBody ResponseEntity getFoyar(){
        return new ResponseEntity(service.findByName("Foyar"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/SpiderNest")
    public @ResponseBody ResponseEntity getSpiderNest(){
        return new ResponseEntity(service.findByName("SpiderNest"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/GoblinRoom")
    public @ResponseBody ResponseEntity getGoblinRoom(){
        return new ResponseEntity(service.findByName("GoblinRoom"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/TreasureTrove")
    public @ResponseBody ResponseEntity getTreasureTrove(){
        return new ResponseEntity(service.findByName("TreasureTrove"), HttpStatus.OK);
    }
}