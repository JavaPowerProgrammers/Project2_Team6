package com.ex.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Daggers")
public class Dagger {
    @Id
    private String id;
    private String name;
    private String description;
    private String damage_dice;
    private String damage_type;
    private String url;

    public Dagger() {
    }

    public Dagger(String name, String description, String damage_dice, String damage_type, String url) {
        this.name = name;
        this.description = description;
        this.damage_dice = damage_dice;
        this.damage_type = damage_type;
        this.url = url;
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

    public String getDamage_dice() {
        return damage_dice;
    }

    public void setDamage_dice(String damage_dice) {
        this.damage_dice = damage_dice;
    }

    public String getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(String damage_type) {
        this.damage_type = damage_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Dagger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage_dice='" + damage_dice + '\'' +
                ", damage_type='" + damage_type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}