package com.ex.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document(collection = "Actions")
public class Action {
    @Id
    private String id;
    private String desc;
    private boolean selected;
    private String image;
    private String name;
    private List<HashMap<Integer, String>> roomActionsLogic;


    public Action() {
    }

    public Action(String desc, boolean selected, String image, String name, List<HashMap<Integer, String>> roomActionsLogic) {
        this.desc = desc;
        this.selected = selected;
        this.image = image;
        this.name = name;
        this.roomActionsLogic = roomActionsLogic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HashMap<Integer, String>> getRoomActionsLogic() {
        return roomActionsLogic;
    }

    public void setRoomActionsLogic(List<HashMap<Integer, String>> roomActionsLogic) {
        this.roomActionsLogic = roomActionsLogic;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", selected=" + selected +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", roomActionsLogic=" + roomActionsLogic +
                '}';
    }
}
