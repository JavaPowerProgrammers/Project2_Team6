package com.ex.repositories;

import com.ex.pojos.Creature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureMongoRepository extends MongoRepository<Creature, String>
{
}