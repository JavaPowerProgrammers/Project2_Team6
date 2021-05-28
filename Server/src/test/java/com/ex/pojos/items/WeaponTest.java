package com.ex.pojos.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    Weapon keyBlade = new Weapon("keyBlade", "Iamkey",
            "picKey","item","thing", "keyblade");
    @Test
    public void setId() {
        keyBlade.setId("1");
        assertEquals("1",keyBlade.getId());
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
    public void setDamage_type() {
        String nam = "keyBlade";
        keyBlade.setDamage_type("keyBlade");
        Assert.assertEquals(nam, keyBlade.getDamage_type());
    }

    @Test
    public void setDamage_at_slot_level() {
        String nam = "keyBlade";
        keyBlade.setDamage_at_slot_level("keyBlade");
        Assert.assertEquals(nam, keyBlade.getDamage_at_slot_level());
    }

    @Test
    public void setUrl() {
        String nam = "keyBlade";
        keyBlade.setUrl("keyBlade");
        Assert.assertEquals(nam, keyBlade.getUrl());
    }
    @Test
    public void setDamageDice()
    {
        String nam = "keyBlade";
        keyBlade.setDamage_dice("keyBlade");
        Assert.assertEquals(nam, keyBlade.getDamage_dice());
    }

    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}