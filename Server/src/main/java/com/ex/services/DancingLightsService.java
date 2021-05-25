package com.ex.services;

import com.ex.pojos.DancingLights;
import com.ex.repositories.DancingLightsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DancingLightsService {

    private DancingLightsMongoRepository repository;

    public DancingLightsService() {
    }

    @Autowired
    public DancingLightsService(DancingLightsMongoRepository repository) {
        this.repository = repository;
    }

    public List<DancingLights> getAllDancingLights(){
        return repository.findAll();
    }

    public void save(DancingLights dancingLights)
    {
        repository.save(dancingLights);
    }

    public void delete(DancingLights dancingLights){
        repository.delete(dancingLights);
    }
}
