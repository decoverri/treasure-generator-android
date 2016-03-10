package com.decoverri.treasuregenerator.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureType implements Serializable {

    private Character letter;
    private String name;
    private String description;
    private ArrayList<Value> values;

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Character getLetter() {
        return letter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }

    public ArrayList<Value> getValues() {
        return values;
    }
}
