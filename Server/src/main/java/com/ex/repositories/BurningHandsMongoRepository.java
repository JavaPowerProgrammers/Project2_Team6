package com.ex.repositories;

import com.ex.pojos.BurningHands;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BurningHandsMongoRepository extends MongoRepository<BurningHands, String> {
}
