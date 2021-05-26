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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Rooms")
    public @ResponseBody ResponseEntity getAllRooms(){
        List<Room> rooms = service.getAllRooms();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }
}