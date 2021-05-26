package com.ex.services;

import com.ex.pojos.Room;
import com.ex.repositories.RoomMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomMongoRepository repository;

    public RoomService() {
    }

    @Autowired
    public RoomService(RoomMongoRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public void save(Room room) {
        repository.save(room);
    }

    public void delete(Room room) {
        repository.delete(room);
    }
}