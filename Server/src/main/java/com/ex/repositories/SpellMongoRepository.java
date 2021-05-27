package com.ex.repositories;

import com.ex.pojos.items.Spell;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellMongoRepository extends MongoRepository<Spell, String> {
    Spell findByName(String name);
}