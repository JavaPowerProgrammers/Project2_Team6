package com.ex.pojos.player;

import com.ex.pojos.items.Item;
import com.ex.pojos.items.Spell;
import com.ex.pojos.items.Weapon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "PlayerCharacters")
public class PlayerCharacter {
    @Id
    private String id;
    private int health;
    private int maxHealth;
    private Species race;
    private DnDClass profession;
    // Player Attributes
    private int dexterity;
    private int strength;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    //Player weapons and spells
    private List<Weapon> weapons;
    private List<Spell> spells;
    private List<Object> items;
    private String playerName;
    //hidden attributes
    private int visibility;//if 1, then yes. if 0, then no.

    public PlayerCharacter() {
    }

    public PlayerCharacter(int health, int maxHealth, Species race, DnDClass profession, int dexterity,
                           int strength, int constitution, int intelligence, int wisdom, int charisma,
                           List<Weapon> weapons, List<Spell> spells, List<Object> items, String playerName, int visibility) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.race = race;
        this.profession = profession;
        this.dexterity = dexterity;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.weapons = weapons;
        this.spells = spells;
        this.items = items;
        this.playerName = playerName;
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Species getRace() {
        return race;
    }

    public void setRace(Species race) {
        this.race = race;
    }

    public DnDClass getProfession() {
        return profession;
    }

    public void setProfession(DnDClass profession) {
        this.profession = profession;
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

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "id='" + id + '\'' +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", race=" + race +
                ", profession=" + profession +
                ", dexterity=" + dexterity +
                ", strength=" + strength +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", weapons=" + weapons +
                ", spells=" + spells +
                ", items=" + items +
                ", playerName='" + playerName + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
