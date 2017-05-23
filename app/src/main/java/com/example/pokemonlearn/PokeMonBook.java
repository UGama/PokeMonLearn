package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 11/5/17.
 */

public class PokeMonBook extends DataSupport {
    private String Name;
    private int ImageResourceId;
    private int Number;
    private int Price;

    public PokeMonBook() {}

    public PokeMonBook(String name, int imageResourceId, int number, int Price) {
        this.Name = name;
        this.ImageResourceId = imageResourceId;
        this.Number = number;
        this.Price = Price;
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

    public int getNumber() {
        return Number;
    }

    public String getName() {
        return Name;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }
}
