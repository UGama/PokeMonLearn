package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 22/5/17.
 */

public class Scene extends DataSupport {
    private int Number;
    private int ImageResource;
    private int Price;

    public Scene(int Number, int ImageResource, int Price) {
        this.Number = Number;
        this.ImageResource = ImageResource;
        this.Price = Price;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public int getNumber() {
        return Number;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }
}
