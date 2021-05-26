package com.ex.repositories;

import com.ex.pojos.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMongoRepository extends MongoRepository<Room, String> {
}