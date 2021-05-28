package com.ex.pojos.player;

import com.ex.pojos.items.Item;
import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharacterTest {
    DnDClass wizardClass = new DnDClass("Wizard", 2, 1, 1, 4, 2, 2,
            new ArrayList<Weapon>(), new ArrayList<Spell>());
    Species dwarfRace = new Species("Dwarf", 1, 3, 3, 1, 3, 1, 1);

    PlayerCharacter keyBlade = new PlayerCharacter(1, 1, dwarfRace, wizardClass, 1,
    1, 1, 1, 1, 1,
    wizardClass.getWeapons(), wizardClass.getSpells(), new ArrayList<Object>(), "keyblade",1);
    @Test
    public void setId() {
        keyBlade.setId("1");
        assertEquals("1",keyBlade.getId());
    }

    @Test
    public void setHealth() {
        int nam = 1;
        keyBlade.setHealth(1);
        assertEquals(nam, keyBlade.getHealth());
    }

    @Test
    public void setMaxHealth() {
        int nam = 1;
        keyBlade.setMaxHealth(1);
        assertEquals(nam, keyBlade.getMaxHealth());
    }

    @Test
    public void setRace() {
        keyBlade.setRace(dwarfRace);
        assertEquals(dwarfRace, keyBlade.getRace());
    }

    @Test
    public void setProfession() {
        keyBlade.setProfession(wizardClass);
        assertEquals(wizardClass, keyBlade.getProfession());
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
    public void setWeapons() {
        keyBlade.setWeapons(wizardClass.getWeapons());
        assertEquals(wizardClass.getWeapons(), keyBlade.getWeapons());

    }

    @Test
    public void setSpells() {
        keyBlade.setSpells(wizardClass.getSpells());
        assertEquals(wizardClass.getSpells(), keyBlade.getSpells());
    }
//new ArrayList<Object>()
    @Test
    public void setItems() {
        keyBlade.setItems(new ArrayList<Object>());
        assertEquals(new ArrayList<Object>(), keyBlade.getItems());
    }

    @Test
    public void setPlayerName() {
        keyBlade.setPlayerName("joe");
        assertEquals("joe",keyBlade.getPlayerName());
    }

    @Test
    public void setHidden_Visibility()
    {
        keyBlade.setVisibility(1);
        assertEquals(1,keyBlade.getVisibility());
    }

    @Test
    public void testToString() {
        String tostring = keyBlade.toString();
        assertEquals(tostring, keyBlade.toString());
    }
}