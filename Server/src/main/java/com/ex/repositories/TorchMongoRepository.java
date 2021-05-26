package com.ex.repositories;

import com.ex.pojos.items.Torch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorchMongoRepository extends MongoRepository<Torch, String> {
}