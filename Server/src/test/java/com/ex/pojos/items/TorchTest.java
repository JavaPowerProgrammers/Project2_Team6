package com.ex.pojos.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TorchTest {
    Torch keyBlade = new Torch("keyBlade", "Iamkey", "picKey","item",1);

    @Test
    public void setId() {
        keyBlade.setId("1");
        Assert.assertEquals("1",keyBlade.getId());
    }
    @Test
    public void setName() {
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
    public void setVisibility() {
        int vis = 1;
        keyBlade.setVisibility(1);
        assertEquals(1,keyBlade.getVisibility());
    }

    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}