package com.ex.pojos.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
This is the weapons Pogo. I think we all know what weapons do. It is also reliant on the
DnD api for some of its information.
 */
@Document(collection = "Weapons")
public class Weapon {
    @Id
    private String id;
    private String name;
    private String description;
    private String damage_type;
    private String damage_at_slot_level;
    private String damage_dice;
    private String url;


    public Weapon() {
    }

    public Weapon(String name, String description, String damage_type,
                  String damage_at_slot_level, String damage_dice, String url) {
        this.name = name;
        this.description = description;
        this.damage_type = damage_type;
        this.damage_at_slot_level = damage_at_slot_level;
        this.damage_dice = damage_dice;
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

    public String getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(String damage_type) {
        this.damage_type = damage_type;
    }

    public String getDamage_at_slot_level() {
        return damage_at_slot_level;
    }

    public void setDamage_at_slot_level(String damage_at_slot_level) {
        this.damage_at_slot_level = damage_at_slot_level;
    }

    public String getDamage_dice() {
        return damage_dice;
    }

    public void setDamage_dice(String damage_dice) {
        this.damage_dice = damage_dice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage_type='" + damage_type + '\'' +
                ", damage_at_slot_level='" + damage_at_slot_level + '\'' +
                ", damage_dice='" + damage_dice + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}