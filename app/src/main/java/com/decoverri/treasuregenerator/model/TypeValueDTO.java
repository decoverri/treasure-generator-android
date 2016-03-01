package com.decoverri.treasuregenerator.model;

/**
 * Created by decoverri on 29/02/16.
 */
public class TypeValueDTO {
    private Double value;
    private Character typeLetter;

    public TypeValueDTO(Double value, Character typeLetter) {
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
