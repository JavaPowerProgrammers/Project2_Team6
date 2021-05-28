package com.ex.pojos;

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
    private String name;
    private int health;
    private String img;
    private String dmg;

    public Creature() {
    }

    public Creature(String name, int health, String img, String dmg) {
        this.name = name;
        this.health = health;
        this.img = img;
        this.dmg = dmg;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDmg() {
        return dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", img='" + img + '\'' +
                ", dmg='" + dmg + '\'' +
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