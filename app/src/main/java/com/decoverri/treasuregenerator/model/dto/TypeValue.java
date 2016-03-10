package com.decoverri.treasuregenerator.model.dto;

import java.io.Serializable;

/**
 * Created by decoverri on 29/02/16.
 */
public class TypeValue implements Serializable {
    private Double value;
    private Character typeLetter;

    public TypeValue(Double value, Character typeLetter) {
        this.value = value;
        this.typeLetter = typeLetter;
    }

    public Double getValue() {
        return value;
    }

    public Character getTypeLetter() {
        return typeLetter;
    }
}
