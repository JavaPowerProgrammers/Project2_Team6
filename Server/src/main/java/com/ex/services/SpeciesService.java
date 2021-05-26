package com.ex.services;

import com.ex.pojos.player.Species;
import com.ex.repositories.SpeciesMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    private SpeciesMongoRepository repository;

    public SpeciesService() {
    }

    @Autowired
    public SpeciesService(SpeciesMongoRepository repository) {
        this.repository = repository;
    }

    public List<Species> getAllSpecies() {
        return repository.findAll();
    }

    public void save(Species species) {
        repository.save(species);
    }

    public void delete(Species species) {
        repository.delete(species);
    }
}