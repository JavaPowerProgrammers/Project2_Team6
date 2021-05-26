package com.ex.repositories;

import com.ex.pojos.items.Key;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyMongoRepository extends MongoRepository<Key, String> {
}