package com.ex.repositories;

import com.ex.pojos.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionMongoRepository extends MongoRepository<Action, String> {
}
