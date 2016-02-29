package com.decoverri.treasuregenerator.model;

import java.io.Serializable;

/**
 * Created by decoverri on 29/02/16.
 */
public class Treasure implements Serializable {
    private String name;
    private Double value;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
