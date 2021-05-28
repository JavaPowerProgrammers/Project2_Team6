package com.ex.pojos.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
spells are basically weapons, but with magic. Right now, we only have 4 spells set up
MM, BH, AA, DL, with Dancing lights not actually doing any damage.
if we have time, might add logic to give the playercharater a +1 visibility if dancing lights
is in the spell inventory.
SPells are also one of the few parts of the code that rely on the APi
 */
@Document(collection = "Spells")
public class Spell {
    @Id
    private String id;
    private String name;
    private String description;
    private String damage_type;
    private String damage_at_slot_level;
    private String url;

    public Spell() {
    }

    public Spell(String name, String description, String damage_type, String damage_at_slot_level, String url) {
        this.name = name;
        this.description = description;
        this.damage_type = damage_type;
        this.damage_at_slot_level = damage_at_slot_level;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage_type='" + damage_type + '\'' +
                ", damage_at_slot_level='" + damage_at_slot_level + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}