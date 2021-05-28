package com.ex.pojos.player;

import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeciesTest {

    Species keyBlade = new Species("barb", 1, 1, 1,
            1, 1, 1,1);
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
    public void setDexterity() {
        int nam = 1;
        keyBlade.setDexterity(1);
        assertEquals(nam, keyBlade.getDexterity());
    }

    @Test
    public void setStrength() {int nam = 1;
        keyBlade.setStrength(1);
        assertEquals(nam, keyBlade.getStrength());
    }

    @Test
    public void setConstitution() {int nam = 1;
        keyBlade.setConstitution(1);
        assertEquals(nam, keyBlade.getConstitution());
    }

    @Test
    public void setIntelligence() {int nam = 1;
        keyBlade.setIntelligence(1);
        assertEquals(nam, keyBlade.getIntelligence());
    }

    @Test
    public void setWisdom() {int nam = 1;
        keyBlade.setWisdom(1);
        assertEquals(nam, keyBlade.getWisdom());
    }

    @Test
    public void setCharisma() {int nam = 1;
        keyBlade.setCharisma(1);
        assertEquals(nam, keyBlade.getCharisma());
    }

    @Test
    public void setHidden_Visibility()
    {
        keyBlade.setHidden_Visibility(1);
        assertEquals(1,keyBlade.getHidden_Visibility());
    }

    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}