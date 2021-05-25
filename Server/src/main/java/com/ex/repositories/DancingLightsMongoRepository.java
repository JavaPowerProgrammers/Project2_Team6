package com.ex.repositories;

import com.ex.pojos.DancingLights;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DancingLightsMongoRepository extends MongoRepository<DancingLights, String> {
}
