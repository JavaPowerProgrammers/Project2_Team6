package com.ex.services;

import com.ex.pojos.Action;
import com.ex.repositories.ActionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    private ActionMongoRepository repository;

    public ActionService() {
    }

    @Autowired
    public ActionService(ActionMongoRepository repository) {
        this.repository = repository;
    }

    public List<Action> getAllActions() {
        return repository.findAll();
    }

    public void save(Action action) {
        repository.save(action);
    }

    public void delete(Action action) {
        repository.delete(action);
    }
}