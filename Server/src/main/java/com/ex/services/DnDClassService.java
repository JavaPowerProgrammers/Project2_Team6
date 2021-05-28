package com.ex.services;

import com.ex.pojos.player.DnDClass;
import com.ex.repositories.DnDClassMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DnDClassService {

    private DnDClassMongoRepository repository;

    public DnDClassService() {
    }

    @Autowired
    public DnDClassService(DnDClassMongoRepository repository) {
        this.repository = repository;
    }

    public List<DnDClass> getAllDnDClasses() {
        return repository.findAll();
    }

    public DnDClass findByName(String name){
        return repository.findByName(name);
    }

    public Optional<DnDClass> findById(String id){
        return repository.findById(id);
    }

    public void save(DnDClass dnDClass) {
        repository.save(dnDClass);
    }

    public void delete(DnDClass dnDClass) {
        repository.delete(dnDClass);
    }
}