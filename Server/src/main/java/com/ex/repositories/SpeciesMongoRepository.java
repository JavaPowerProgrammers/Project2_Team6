package com.ex.repositories;

import com.ex.pojos.player.Species;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesMongoRepository extends MongoRepository<Species, String> {
}
