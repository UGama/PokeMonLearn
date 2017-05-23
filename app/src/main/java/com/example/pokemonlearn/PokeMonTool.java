package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 11/5/17.
 */

public class PokeMonTool extends DataSupport {
    private String Name;
    private int ImageResourceId;
    private int Number;
    private int Price;

    public PokeMonTool() {}

    public PokeMonTool(String name, int imageResourceId, int number, int price) {
        this.Name = name;
        this.ImageResourceId = imageResourceId;
        this.Number = number;
        this.Price = price;
    }

    public int getNumber() {
        return Number;
    }

    public String getName() {
        return Name;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }
}
