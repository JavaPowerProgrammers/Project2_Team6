package com.ex.controllers;

import com.ex.pojos.Creature;
import com.ex.services.CreatureService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.*;

public class CreatureControllerTest
{
    


    @Test
    public void getAllCreatures()
    {
        
        CreatureService service = new CreatureService();
        Creature fred = new Creature();
        service.save(fred);
        List<Creature> creatures = service.getAllCreatures();
        ResponseEntity joe = new ResponseEntity(creatures, HttpStatus.OK);
        CreatureController billy = new CreatureController(service);
        assertEquals(joe, billy.getAllCreatures());
    }
}