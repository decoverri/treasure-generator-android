package com.decoverri.treasuregenerator.model.dto;

import com.decoverri.treasuregenerator.model.Treasure;

import java.io.Serializable;
import java.util.List;

/**
 * Created by decoverri on 08/03/16.
 */
public class GenerationResult implements Serializable {

    private final TypeValue typeValue;
    private final List<Treasure> treasures;

    public GenerationResult(TypeValue typeValue, List<Treasure> treasures) {
        this.typeValue = typeValue;
        this.treasures = treasures;
    }

    public TypeValue getTypeValue() {
        return typeValue;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }
}
