package com.decoverri.treasuregenerator.model;

import com.decoverri.treasuregenerator.R;

import java.util.ArrayList;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureType {
    private Long id;
    private Integer drawable;
    private Character letter;
    private String name;
    private String description;
    private ArrayList<Integer> values;

    public TreasureType(int drawable) {
        this.drawable = drawable;
    }

    public TreasureType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDrawable() {
        return drawable;
    }

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

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }
}
