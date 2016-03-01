package com.decoverri.treasuregenerator.util;

import com.decoverri.treasuregenerator.model.Treasure;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class JSONConverter {

    public List<Treasure> resultToTreasures(String result) {
        List<Treasure> treasures = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONObject(result).getJSONArray("treasures");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Treasure treasure = new Treasure();
                treasure.setName(jsonObject.getString("name"));
                treasure.setValue(jsonObject.getDouble("value"));
                treasures.add(treasure);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treasures;
    }
}
