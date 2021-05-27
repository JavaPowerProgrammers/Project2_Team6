package com.ex.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "Actions")
public class Action {
    @Id
    private String id;
    private String desc;
    private boolean selected;
    private String image;
    private String name;
    private List<Map<Integer, String>> actionFragments;

    public Action() {
    }

    public Action(String desc, boolean selected, String image, String name, List<Map<Integer, String>> actionFragments) {
        this.desc = desc;
        this.selected = selected;
        this.image = image;
        this.name = name;
        this.actionFragments = actionFragments;
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

    public List<Map<Integer, String>> getActionFragments() {
        return actionFragments;
    }

    public void setActionFragments(List<Map<Integer, String>> actionFragments) {
        this.actionFragments = actionFragments;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", selected=" + selected +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", actionFragments=" + actionFragments +
                '}';
    }
}
