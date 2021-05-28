package com.ex.pojos.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
The rope items one purpose is to ensure success when you climb up the cliff in the
goblin room. Or any cliff for that matter i suppose. that it
 */
@Document(collection = "Ropes")
public class Rope implements Item{
    @Id
    private String id;
    private String name;
    private String description;
    private String img;
    private String tag;

    public Rope()
    {

    }

    public Rope(String name, String description, String img, String tag) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Rope{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
