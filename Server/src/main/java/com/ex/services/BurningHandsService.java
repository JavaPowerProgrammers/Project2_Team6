package com.ex.services;

import com.ex.pojos.BurningHands;
import com.ex.repositories.BurningHandsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurningHandsService {

    private BurningHandsMongoRepository repository;

    public BurningHandsService() {
    }

    @Autowired
    public BurningHandsService(BurningHandsMongoRepository repository) {
        this.repository = repository;
    }

    public List<BurningHands> getAllBurningHands(){
        return repository.findAll();
    }

    public void save(BurningHands burningHands)
    {
        repository.save(burningHands);
    }

    public void delete(BurningHands burningHands){
        repository.delete(burningHands);
    }
}
