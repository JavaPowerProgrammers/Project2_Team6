package com.ex.pojos;

import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
Room keyBlade = new Room();
    @Test
    public void setId() {
        keyBlade.setId("1");
        assertEquals("1", keyBlade.getId());
    }

    @Test
    public void setCurrentMiniDisplay() {
        keyBlade.setCurrentMiniDisplay("1");
        assertEquals("1", keyBlade.getCurrentMiniDisplay());
    }

    @Test
    public void setRoomBGImage() {
        keyBlade.setRoomBGImage("1");
        assertEquals("1", keyBlade.getRoomBGImage());
    }

    @Test
    public void setDesc() {
        keyBlade.setDesc("1");
        assertEquals("1", keyBlade.getDesc());
    }

    @Test
    public void setActions() {
        List joe = new ArrayList<Action>();
        keyBlade.setActions(joe);
        assertEquals(joe, keyBlade.getActions());
    }

//    @Test
//    public void setRoomActionsChosen()
//    {
//        ArrayList<String> joe = new ArrayList<String>();
//        keyBlade.setRoomActionsChosen(new ArrayList<joe>());
//        assertEquals(new ArrayList<Object>(), keyBlade.getRoomActionsChosen());
//    }

    @Test
    public void setWeapons() {
        keyBlade.setWeapons(new ArrayList<Weapon>());
        assertEquals(new ArrayList<Weapon>(), keyBlade.getWeapons());
    }

    @Test
    public void setSpells() {
        keyBlade.setSpells(new ArrayList<Spell>());
        assertEquals(new ArrayList<Spell>(), keyBlade.getSpells());
    }

    @Test
    public void setItems() {
        keyBlade.setItems(new ArrayList<Object>());
        assertEquals(new ArrayList<Object>(), keyBlade.getItems());
    }

    @Test
    public void setNextRoom() {
        keyBlade.setNextRoom("1");
        assertEquals("1", keyBlade.getNextRoom());
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