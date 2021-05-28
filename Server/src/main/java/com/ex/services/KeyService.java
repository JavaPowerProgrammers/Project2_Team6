package com.ex.services;

import com.ex.pojos.items.Key;
import com.ex.repositories.KeyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyService {

    private KeyMongoRepository repository;

    public KeyService() {
    }

    @Autowired
    public KeyService(KeyMongoRepository repository) {
        this.repository = repository;
    }

    public List<Key> getAllKeys() {
        return repository.findAll();
    }

    public void save(Key key) {
        repository.save(key);
    }

    public void delete(Key key) {
        repository.delete(key);
    }
}