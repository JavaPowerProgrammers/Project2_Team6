package com.ex.pojos;

import com.ex.pojos.Action;
import com.ex.pojos.items.Item;
import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "Rooms")
public class Room {
    @Id
    private String id;
    private String currentMiniDisplay;
    private String roomBGImage;
    private String desc;
    private List<Action> actions;
    private List<Map<String, Boolean>> roomActionsChosen;
    private List<Weapon> weapons;
    private List<Spell> spells;
    private List<Item> items;
    protected String nextRoom;
    private String name;

    public Room() {
    }

    public Room(String currentMiniDisplay, String roomBGImage, String desc, List<Action> actions, List<Map<String, Boolean>> roomActionsChosen, List<Weapon> weapons, List<Spell> spells, List<Item> items, String nextRoom, String name) {
        this.currentMiniDisplay = currentMiniDisplay;
        this.roomBGImage = roomBGImage;
        this.desc = desc;
        this.actions = actions;
        this.roomActionsChosen = roomActionsChosen;
        this.weapons = weapons;
        this.spells = spells;
        this.items = items;
        this.nextRoom = nextRoom;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentMiniDisplay() {
        return currentMiniDisplay;
    }

    public void setCurrentMiniDisplay(String currentMiniDisplay) {
        this.currentMiniDisplay = currentMiniDisplay;
    }

    public String getRoomBGImage() {
        return roomBGImage;
    }

    public void setRoomBGImage(String roomBGImage) {
        this.roomBGImage = roomBGImage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Map<String, Boolean>> getRoomActionsChosen() {
        return roomActionsChosen;
    }

    public void setRoomActionsChosen(List<Map<String, Boolean>> roomActionsChosen) {
        this.roomActionsChosen = roomActionsChosen;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(String nextRoom) {
        this.nextRoom = nextRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", currentMiniDisplay='" + currentMiniDisplay + '\'' +
                ", roomBGImage='" + roomBGImage + '\'' +
                ", desc='" + desc + '\'' +
                ", actions=" + actions +
                ", roomActionsChosen=" + roomActionsChosen +
                ", weapons=" + weapons +
                ", spells=" + spells +
                ", items=" + items +
                ", nextRoom='" + nextRoom + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
