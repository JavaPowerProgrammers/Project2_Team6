package com.ex.pojos.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Keys")
public class Key
{
    @Id
    private String id;
    private String name;
    private String description;
    //add the below to the factory
//    private String Desc= " This brightly lit torch illuminates the entire room you are in. As a Flameable object, " +
//            "it can burn highly flammable substances";
    private int visibility;//this will be 1, and will be added to playercharacter
    public Key()
    {

    }
    public Key(String name, String description, int visibility)
    {
        this.name = name;
        this.description = description;
        this.visibility = visibility;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getVisibility()
    {
        return visibility;
    }

    public void setVisibility(int visibility)
    {
        this.visibility = visibility;
    }

    @Override
    public String toString()
    {
        return "Key{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
