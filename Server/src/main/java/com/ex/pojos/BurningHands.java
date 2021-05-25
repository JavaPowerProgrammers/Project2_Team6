package com.ex.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BurningHands")
public class BurningHands {
    @Id
    private String id;
    private String name;
    private String description;
    private String damage_at_slot_level;
    private String damage_type;
    private String url;

    public BurningHands() {
    }

    public BurningHands(String name, String description, String damage_at_slot_level, String damage_type, String url) {
        this.name = name;
        this.description = description;
        this.damage_at_slot_level = damage_at_slot_level;
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

    public String getDamage_at_slot_level() {
        return damage_at_slot_level;
    }

    public void setDamage_at_slot_level(String damage_at_slot_level) {
        this.damage_at_slot_level = damage_at_slot_level;
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
        return "BurningHands{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage_at_slot_level='" + damage_at_slot_level + '\'' +
                ", damage_type='" + damage_type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}