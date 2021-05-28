package com.ex.services;

import com.ex.pojos.items.Torch;
import com.ex.repositories.TorchMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorchService {

    private TorchMongoRepository repository;

    public TorchService() {
    }

    @Autowired
    public TorchService(TorchMongoRepository repository) {
        this.repository = repository;
    }

    public List<Torch> getAllTorches() {
        return repository.findAll();
    }

    public void save(Torch torch) {
        repository.save(torch);
    }

    public void delete(Torch torch) {
        repository.delete(torch);
    }
}