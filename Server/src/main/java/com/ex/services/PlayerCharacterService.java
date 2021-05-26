package com.ex.services;

import com.ex.pojos.player.PlayerCharacter;
import com.ex.repositories.PlayerCharacterMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerCharacterService {

    private PlayerCharacterMongoRepository repository;

    public PlayerCharacterService() {
    }

    @Autowired
    public PlayerCharacterService(PlayerCharacterMongoRepository repository) {
        this.repository = repository;
    }

    public List<PlayerCharacter> getAllPlayerCharacters() {
        return repository.findAll();
    }

    public void save(PlayerCharacter playerCharacter) {
        repository.save(playerCharacter);
    }

    public void delete(PlayerCharacter playerCharacter) {
        repository.delete(playerCharacter);
    }
}