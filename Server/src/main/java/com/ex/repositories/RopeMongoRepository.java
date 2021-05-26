package com.ex.repositories;

import com.ex.pojos.items.Rope;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RopeMongoRepository extends MongoRepository<Rope, String> {
}
