package com.ex.services;

import com.ex.pojos.Dagger;
import com.ex.repositories.DaggerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaggerService {

    private DaggerMongoRepository repository;

    public DaggerService() {
    }

    @Autowired
    public DaggerService(DaggerMongoRepository repository) {
        this.repository = repository;
    }

    public List<Dagger> getAllDaggers(){
        return repository.findAll();
    }

    public void save(Dagger dagger)
    {
        repository.save(dagger);
    }

    public void delete(Dagger dagger){
        repository.delete(dagger);
    }
}
