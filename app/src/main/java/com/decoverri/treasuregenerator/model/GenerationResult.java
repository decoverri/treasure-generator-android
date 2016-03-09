package com.decoverri.treasuregenerator.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by decoverri on 08/03/16.
 */
public class GenerationResult implements Serializable {

    private final TypeValueDTO typeValue;
    private final List<Treasure> treasures;

    public GenerationResult(TypeValueDTO typeValue, List<Treasure> treasures) {
        this.typeValue = typeValue;
        this.treasures = treasures;
    }

    public TypeValueDTO getTypeValue() {
        return typeValue;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }
}
