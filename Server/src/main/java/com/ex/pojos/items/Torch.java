package com.ex.pojos.items;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Torches")
public class Torch implements Item{
    @Id
    private String id;
    private String name;
    private String description;
    private String img;
    private String tag;
    //add the below to the factory
//    private String Desc= " This brightly lit torch illuminates the entire room you are in. As a Flameable object, " +
//            "it can burn highly flammable substances";
    private int visibility;//this will be 1, and will be added to playercharacter

    public Torch() {
    }

    public Torch(String name, String description, String img, String tag, int visibility) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.tag = tag;
        this.visibility = visibility;
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

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Torch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", tag='" + tag + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}