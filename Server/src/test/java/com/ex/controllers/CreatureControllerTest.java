package com.ex.controllers;

//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import com.ex.pojos.Creature;
import com.ex.services.CreatureService;
//import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CreatureControllerTest {
    private SpringApplication app;
    @Autowired
    private static CreatureService service;
    @Autowired
    private static CreatureController controller;
    private static Creature c1;

//    @BeforeClass
//    public static void setUpClass() {
////        md = new MongoManagerDao(connector, "ers", "managerstest");
////        ms = new MongoManagerService(md);
////        mc = new ManagerController(ms);
//    }

    @BeforeEach
    public void setUp(){
        c1 = new Creature("Goblin", 5, "./res/gifs/creatures/goblin.gif", "1d4");
    }

    @AfterEach
    public void tearDown(){
        service.delete(c1);
    }

//    @AfterClass
//    public static void tearDownClass() {
//        System.out.println("Creature Controller Tests complete.");
//    }

//    @Test
//    public void getAllCreaturesTest(){
//        service.save(c1);
//
//        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
//        ResponseEntity actual = controller.getAllCreatures();
//        assertNotEquals(expected, actual);
//    }
}

//
//    @Test
//    public void loginTest() {
//        ms.save(m1);
//        String path = "/login";
//        String body = "{\"username\": \"bob\", \"password\":\"bob\"}";
//        JSONObject obj = mc.login(body);
//        System.out.println("obj" + obj);
//        String expected = "{\"firstName\":\"Bob\",\"lastName\":\"Dole\",\"password\":\"bob\",\"role\"" +
//                ":\"Manager\",\"_id\":\""+ m1.getId().toString() +"\",\"loginStatus\":true,\"username\":\"bob\"}";
//        String actual = obj.toString();
//
//        System.out.println("actual " + actual);
//        Assert.assertEquals(expected, actual);
//    }
//}

