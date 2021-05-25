package com.ex.repositories;

import com.ex.pojos.AcidArrow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcidArrowMongoRepository extends MongoRepository <AcidArrow, String> {
}
