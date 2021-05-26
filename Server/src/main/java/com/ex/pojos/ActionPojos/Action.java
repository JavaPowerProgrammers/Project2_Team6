package com.ex.pojos.ActionPojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Actions")
public class Action {
    @Id
    private String id;
    private String desc;
    private boolean selected;
    private String image;
    private String name;
    //private List<String> roomActionsLogic


    public Action() {
    }

    public Action(String desc, boolean selected, String image) {
        this.desc = desc;
        this.selected = selected;
        this.image = image;
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

    @Override
    public String toString() {
        return "Action{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", selected=" + selected +
                ", image='" + image + '\'' +
                '}';
    }
}
