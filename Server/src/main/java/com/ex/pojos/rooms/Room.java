package com.ex.pojos.rooms;

import com.ex.pojos.ActionPojos.Action;
import org.springframework.data.annotation.Id;

import java.util.List;

public abstract class Room {
    @Id
    private String id;
    protected List<Action> actions;
    protected String nextRoom;
    protected String backgroundImage;
    protected String desc;
    private String name;


}
