package com.ex.repositories;

import com.ex.pojos.Dagger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DaggerMongoRepository extends MongoRepository <Dagger, String> {
}
