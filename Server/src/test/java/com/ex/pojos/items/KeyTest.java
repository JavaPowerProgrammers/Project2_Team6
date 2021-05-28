package com.ex.pojos.items;

import org.junit.Before;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class KeyTest
{
    Key keyBlade = new Key("keyBlade", "Iamkey", "picKey","item");

    @Test
    public void setId() {
        keyBlade.setId("1");
        assertEquals("1",keyBlade.getId());
    }
    @Test
    public void setName()
    {
        String nam = "keyBlade";
        keyBlade.setName("keyBlade");
        assertEquals(nam, keyBlade.getName());
    }
    @Test
    public void setDescription() {
        String nam = "keyBlade";
        keyBlade.setDescription("keyBlade");
        assertEquals(nam, keyBlade.getDescription());
    }
    @Test
    public void setImg() {
        String nam = "keyBlade";
        keyBlade.setImg("keyBlade");
        assertEquals(nam, keyBlade.getImg());
    }
    @Test
    public void setTag() {
        String nam = "keyBlade";
        keyBlade.setTag("keyBlade");
        assertEquals(nam, keyBlade.getTag());
    }
    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}