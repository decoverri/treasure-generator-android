package com.decoverri.treasuregenerator.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

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

    public String getFormattedValue(){
        return NumberFormat.getNumberInstance(Locale.US).format(value) + " gp";
    }
}
