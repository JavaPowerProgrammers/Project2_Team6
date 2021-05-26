package com.ex.services;

import com.ex.pojos.items.Spell;
import com.ex.repositories.SpellMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {

    private SpellMongoRepository repository;

    public SpellService() {
    }

    @Autowired
    public SpellService(SpellMongoRepository repository) {
        this.repository = repository;
    }

    public List<Spell> getAllSpells() {
        return repository.findAll();
    }

    public void save(Spell spell) {
        repository.save(spell);
    }

    public void delete(Spell spell) {
        repository.delete(spell);
    }
}