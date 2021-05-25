package com.ex.services;

import com.ex.pojos.User;
import com.ex.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMongoRepository repository;

    public UserService() {
    }

    @Autowired
    public UserService(UserMongoRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public void save(User user)
    {
        repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }
}
