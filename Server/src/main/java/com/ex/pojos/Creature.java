package com.ex.pojos;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//package com.ex.pojos.monsters.Creature;
@Document
@Data
public class Creature
{
    @Id
    private String ID;
    private int health;
    private String dmg;
    private String img;
    private String name;

    public Creature() {
    }

    public Creature(int health, String dmg, String img, String name) {
        this.health = health;
        this.dmg = dmg;
        this.img = img;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getDmg() {
        return dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "ID='" + ID + '\'' +
                ", health=" + health +
                ", dmg='" + dmg + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //    public int rollDamage()
//    {
//        int dam = 0;
//        if(getDamage().equals("1d4"))
//        {
//            dam =  (int)(Math.random() * 4);
//        }
//        if(getDamage().equals("1d6"))
//        {
//            dam =  (int)(Math.random() * 6);
//        }
//        if(getDamage().equals("1d8"))
//        {
//            dam = (int)(Math.random() * 8);
//        }
//        if(getDamage().equals("1d10"))
//        {
//            dam = (int)(Math.random() * 10);
//        }
//        if(getDamage().equals("1d12"))
//        {
//            dam = (int)(Math.random() * 12);
//        }
//        if(getDamage().equals("2d6"))
//        {
//            dam = (2*(int)(Math.random() * 6));
//        }
//        return dam;
//    }
}