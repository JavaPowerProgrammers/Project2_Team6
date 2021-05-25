package com.ex.services;

import com.ex.pojos.AcidArrow;
import com.ex.repositories.AcidArrowMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcidArrowService {

    private AcidArrowMongoRepository repository;

    public AcidArrowService() {
    }

    @Autowired
    public AcidArrowService(AcidArrowMongoRepository repository) {
        this.repository = repository;
    }

    public List<AcidArrow> getAllAcidArrows(){
        return repository.findAll();
    }

    public void save(AcidArrow acidArrow)
    {
        repository.save(acidArrow);
    }

    public void delete(AcidArrow acidArrow){
        repository.delete(acidArrow);
    }
}
