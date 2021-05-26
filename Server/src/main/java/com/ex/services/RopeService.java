package com.ex.services;

import com.ex.pojos.items.Rope;
import com.ex.repositories.RopeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RopeService {

    private RopeMongoRepository repository;

    public RopeService() {
    }

    @Autowired
    public RopeService(RopeMongoRepository repository) {
        this.repository = repository;
    }

    public List<Rope> getAllRopes() {
        return repository.findAll();
    }

    public void save(Rope rope) {
        repository.save(rope);
    }

    public void delete(Rope rope) {
        repository.delete(rope);
    }
}