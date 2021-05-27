package com.ex.repositories;

import com.ex.pojos.items.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponMongoRepository extends MongoRepository<Weapon, String> {
    Weapon findByName(String name);
}
