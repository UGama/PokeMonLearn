package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 8/5/17.
 */

public class OwnPet extends DataSupport {
    private int Id;
    private String Name;
    private int Position;

    public OwnPet() {}

    public void setName(String name) {
        Name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public int getPosition() {
        return Position;
    }
}
