package com.ex.pojos.player;

import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "DnDClasses")
public class DnDClass {
    @Id
    private String Id;
    private String name;
    private int dexterity;
    private int strength;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private List<Weapon> weapons;
    private List<Spell> spells;

    public DnDClass() {
    }

    public DnDClass(String name, int dexterity, int strength, int constitution, int intelligence, int wisdom, int charisma, List<Weapon> weapons, List<Spell> spells) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.weapons = weapons;
        this.spells = spells;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        charisma = charisma;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    @Override
    public String toString() {
        return "DnDClass{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", dexterity=" + dexterity +
                ", strength=" + strength +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", weapons=" + weapons +
                ", spells=" + spells +
                '}';
    }
}
