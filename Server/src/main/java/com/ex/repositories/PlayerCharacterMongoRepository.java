package com.ex.repositories;

import com.ex.pojos.player.PlayerCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCharacterMongoRepository extends MongoRepository<PlayerCharacter, String> {
}