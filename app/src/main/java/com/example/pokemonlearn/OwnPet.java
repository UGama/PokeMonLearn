package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 8/5/17.
 */

public class OwnPet extends DataSupport {
    private int Number;
    private String Name;
    private int ImageResourceId;
    private int BallImageResourceId;

    public OwnPet() {}

    public OwnPet(String name, int imageResourceId, int number, int ballImageResourceId) {
        Name = name;
        ImageResourceId = imageResourceId;
        Number = number;
        BallImageResourceId = ballImageResourceId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public String getName() {
        return Name;
    }

    public int getNumber() {
        return Number;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setBallImageResourceId(int ballImageResourceId) {
        BallImageResourceId = ballImageResourceId;
    }

    public int getBallImageResourceId() {
        return BallImageResourceId;
    }
}
