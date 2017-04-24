package com.example.pokemonlearn;

/**
 * Created by Gama on 9/4/17.
 */

public class PokeMon {
    int Number;
    String Name;
    int ImageSourceId;

    public PokeMon(int Number, String Name, int imageSourceId) {
        this.Number = Number;
        this.Name = Name;
        this.ImageSourceId = imageSourceId;
    }

    public int getNumber() {
        return Number;
    }
    public String getName() {
        return Name;
    }
    public int getImageSourceId() {
        return ImageSourceId;
    }

}
