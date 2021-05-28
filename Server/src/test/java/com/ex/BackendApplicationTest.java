package com.ex;

import org.junit.*;
//import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class BackendApplicationTest {


    @Test
    public void main()
    {
        assertEquals("","");
    }

    @Test
    public void run()
    {
        String[] args = new String[0];
        SpringApplication.run(BackendApplication.class, args);
        assertTrue(true);
    }
}