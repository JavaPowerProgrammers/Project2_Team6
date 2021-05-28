package com.ex.pojos;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureTest {
    Creature keyBlade = new Creature();
    @Test
    public void setID()
    {
        keyBlade.setID("1");
        assertEquals("1", keyBlade.getID());
    }

    @Test
    public void setHealth() {
        keyBlade.setHealth(1);
        assertEquals(1,keyBlade.getHealth());
    }

    @Test
    public void setDmg() {
        keyBlade.setDmg("1");
        assertEquals("1", keyBlade.getDmg());
    }

    @Test
    public void setImg() {
        keyBlade.setImg("1");
        assertEquals("1", keyBlade.getImg());
    }

    @Test
    public void setName() {
        keyBlade.setName("1");
        assertEquals("1", keyBlade.getName());
    }

    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}