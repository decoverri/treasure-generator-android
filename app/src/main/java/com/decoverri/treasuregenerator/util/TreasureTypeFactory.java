package com.decoverri.treasuregenerator.util;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.model.Value;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by decoverri on 29/02/16.
 */
public class TreasureTypeFactory {
    private Activity activity;

    public TreasureTypeFactory(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<TreasureType> createFromJson(int json) {
        Scanner scanner = new Scanner(activity.getResources().openRawResource(json));
        ArrayList<TreasureType> treasureTypes = new ArrayList<>();
        try {
            while(scanner.hasNext()){
                String treasureTypeJSON = scanner.nextLine();
                JSONObject typeJSON = new JSONObject(treasureTypeJSON);

                TreasureType type = createTreasureType(typeJSON);
                treasureTypes.add(type);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treasureTypes;
    }

    @NonNull
    private TreasureType createTreasureType(JSONObject typeJSON) throws JSONException {
        TreasureType type = new TreasureType(getDrawableId(typeJSON.getString("resource")));

        type.setLetter(typeJSON.getString("letter").charAt(0));
        type.setName(typeJSON.getString("name"));
        type.setDescription(typeJSON.getString("description"));
        type.setValues(getValues(typeJSON));

        return type;
    }

    private int getDrawableId(String drawable) {
        return activity.getResources().getIdentifier(drawable, "drawable", activity.getPackageName());
    }

    @NonNull
    private ArrayList<Value> getValues(JSONObject typeJSON) throws JSONException {
        JSONArray jsonArray = typeJSON.getJSONObject("values").getJSONArray("value");
        ArrayList<Value> values = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            values.add(new Value(jsonArray.getJSONObject(i).getDouble("value")));
        }
        return values;
    }
}
