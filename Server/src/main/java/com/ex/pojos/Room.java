package com.ex.pojos;

import com.ex.pojos.Action;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Rooms")
public class Room {
    @Id
    private String id;
    protected List<Action> actions;
    protected String nextRoom;
    protected String backgroundImage;
    protected String desc;
    private String name;

    public Room() {
    }

    public Room(List<Action> actions, String nextRoom, String backgroundImage, String desc, String name) {
        this.actions = actions;
        this.nextRoom = nextRoom;
        this.backgroundImage = backgroundImage;
        this.desc = desc;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(String nextRoom) {
        this.nextRoom = nextRoom;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
                ", actions=" + actions +
                ", nextRoom='" + nextRoom + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
