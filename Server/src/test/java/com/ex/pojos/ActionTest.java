package com.ex.pojos;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionTest {

    public Action keyBlade = new Action();
    @Test
    public void setId() {
        keyBlade.setId("1");
        assertEquals("1", keyBlade.getId());
    }

    @Test
    public void setDesc() {
        keyBlade.setDesc("1");
        assertEquals("1", keyBlade.getDesc());
    }

    @Test
    public void setSelected() {
        keyBlade.setSelected(true);
        assertEquals(true, keyBlade.isSelected());
    }

    @Test
    public void setImage() {
        keyBlade.setImage("1");
        assertEquals("1", keyBlade.getImage());
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