package com.ex.pojos.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    //"This weapon is a " + name + " that " + type + " your foes. Dealing up to" + d + " damage";

//    1. Home screen, player presses play, choses dungeon, calls initial Data.
//
//    2.
//    davidItemsData= {
//            "rope": {"name":Rope, "desc":Its a rope, "imgURL":imgDir},
//            "key": {"name":key, "desc":Its a key, "imgURL":imgDir},
//            "torch": {"name":torch, "desc":Its a Torch, "imgURL":imgDir},
//
//            "long-sword":{"name":LongSword,.......}
//    }
//    ,
//    FirstroomsData={}
//    ,
//    APIListData=["long-sword","acid-arrow".....]
//    ,
//    playerData={"wizard":["acid-arrow"], "fighter":["long-sword"]}
//
//    3. Loops through
//    -call bens methods => cachedData api "http/DND/APIequipments/acid-arrow" => "acid-arrow":{} => add to davidsItemData
//
//    4. Ready To Play , to pick Race, Class
//
//
//    apiCachedData={
//            "acid-arrow": {"attk":5, "img-url":-, "desc":"Burns the person with accept"},
//        ...
//    }

    public Weapon() {
    }

    public Weapon(String name, String description, String damage_type, String damage_at_slot_level, String damage_dice, String url) {
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