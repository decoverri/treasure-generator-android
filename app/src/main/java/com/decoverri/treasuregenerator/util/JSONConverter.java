package com.decoverri.treasuregenerator.util;

import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.TypeValueDTO;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class JSONConverter {

    public String typeValueToJSON(TypeValueDTO typeValue) {
        try {
            return new JSONStringer().object()
                    .key("value").value(typeValue.getValue())
                    .key("letter").value(typeValue.getTypeLetter())
                    .endObject().toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Treasure> resultToTreasures(String result) {
        List<Treasure> treasures = new ArrayList<>();

        Treasure treasure1 = new Treasure();
        treasure1.setName("sword");
        treasure1.setValue(1000.0);
        treasures.add(treasure1);

        Treasure treasure2 = new Treasure();
        treasure2.setName("axe");
        treasure2.setValue(1500.0);
        treasures.add(treasure2);

        Treasure treasure3 = new Treasure();
        treasure3.setName("axe");
        treasure3.setValue(200.0);
        treasures.add(treasure3);

        return treasures;
    }
}
