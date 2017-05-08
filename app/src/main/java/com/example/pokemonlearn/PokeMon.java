package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 9/4/17.
 */

public class PokeMon extends DataSupport{
    int Number;
    String Name;
    int ImageSourceId;
    int Weight;
    int MapId;

    public PokeMon() {}

    public PokeMon(int Number, String Name, int imageSourceId, int Weight, int MapId) {
        this.Number = Number;
        this.Name = Name;
        this.ImageSourceId = imageSourceId;
        this.Weight = Weight;
        this.MapId = MapId;
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

    public int getWeight() {
        return Weight;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageSourceId(int imageSourceId) {
        ImageSourceId = imageSourceId;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public void setMapId(int mapId) {
        MapId = mapId;
    }

    public int getMapId() {
        return MapId;
    }

}
