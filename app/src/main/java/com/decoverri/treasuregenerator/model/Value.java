package com.decoverri.treasuregenerator.model;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * Created by decoverri on 02/03/16.
 */
public class Value implements Serializable {
    private Double value;

    public Value(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return NumberFormat.getInstance().format(value) + " gp";
    }
}
