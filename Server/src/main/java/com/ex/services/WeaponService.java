package com.ex.services;

import com.ex.pojos.items.Weapon;
import com.ex.repositories.WeaponMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private WeaponMongoRepository repository;

    public WeaponService() {
    }

    @Autowired
    public WeaponService(WeaponMongoRepository repository) {
        this.repository = repository;
    }

    public List<Weapon> getAllWeapons() {
        return repository.findAll();
    }

    public Weapon findByName(String name){
        return repository.findByName(name);
    }

    public void save(Weapon weapon) {
        repository.save(weapon);
    }

    public void delete(Weapon weapon) {
        repository.delete(weapon);
    }
}