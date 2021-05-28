package com.ex.services;//package com.ex.pojos.monsters.Creature;

import com.ex.pojos.Creature;
import com.ex.repositories.CreatureMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {

    private CreatureMongoRepository repository;

    public CreatureService() {
    }

    @Autowired
    public CreatureService(CreatureMongoRepository repository) {
        this.repository = repository;
    }

    public List<Creature> getAllCreatures() {
        return repository.findAll();
    }

    public void save(Creature creature) {
        repository.save(creature);
    }

    public void delete(Creature creature) {
        repository.delete(creature);
    }
}