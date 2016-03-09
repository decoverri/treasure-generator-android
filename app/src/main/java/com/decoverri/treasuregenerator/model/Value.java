package com.decoverri.treasuregenerator.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

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
        return NumberFormat.getNumberInstance(Locale.US).format(value) + " gp";
    }
}
