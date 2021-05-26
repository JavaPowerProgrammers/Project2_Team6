package com.ex.pojos.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Species")
public class Species {
    @Id
    private String id;
    private String name;
    private int dexterity;//example. elf will be 2
    private int strength;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hidden_Visibility;

    public Species() {
    }

    public Species(String name, int dexterity, int strength, int constitution, int intelligence, int wisdom, int charisma, int hidden_Visibility) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.hidden_Visibility = hidden_Visibility;
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
        this.charisma = charisma;
    }

    public int getHidden_Visibility() {
        return hidden_Visibility;
    }

    public void setHidden_Visibility(int hidden_Visibility) {
        this.hidden_Visibility = hidden_Visibility;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dexterity=" + dexterity +
                ", strength=" + strength +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", hidden_Visibility=" + hidden_Visibility +
                '}';
    }
}
