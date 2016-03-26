package com.decoverri.treasuregenerator.model.dto;

import com.decoverri.treasuregenerator.model.TreasureType;

import java.io.Serializable;

/**
 * Created by decoverri on 29/02/16.
 */
public class TypeValue implements Serializable {
    private TreasureType type;
    private Double value;

    public TypeValue(Double value, TreasureType type) {
        this.value = value;
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public Character getTypeLetter() {
        return type.getLetter();
    }

    public String getTypeName(){
        return type.getName();
    }
}
