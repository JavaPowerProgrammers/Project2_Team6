package com.ex.pojos;

import com.sun.javafx.beans.IDProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//package com.ex.pojos.monsters.Creature;
@Document
public class Creature
{
    @Id
    private String ID;
    private int health;
    private String damage;
    private String name;

    public Creature(int health, String damage, String name)
    {
        this.health = health;
        this.damage = damage;
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

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }
    public int rollDamage()
    {
        int dam = 0;
        if(getDamage().equals("1d4"))
        {
            dam =  (int)(Math.random() * 4);
        }
        if(getDamage().equals("1d6"))
        {
            dam =  (int)(Math.random() * 6);
        }
        if(getDamage().equals("1d8"))
        {
            dam = (int)(Math.random() * 8);
        }
        if(getDamage().equals("1d10"))
        {
            dam = (int)(Math.random() * 10);
        }
        if(getDamage().equals("1d12"))
        {
            dam = (int)(Math.random() * 12);
        }
        if(getDamage().equals("2d6"))
        {
            dam = (2*(int)(Math.random() * 6));
        }
        return dam;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Creature{" +
                "ID='" + ID + '\'' +
                ", health=" + health +
                ", damage='" + damage + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}