package com.decoverri.treasuregenerator.task;

import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.TypeValueDTO;
import com.decoverri.treasuregenerator.util.JSONConverter;

import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class LootClient {

    private JSONConverter converter;

    public LootClient() {
        converter = new JSONConverter();
    }

    public List<Treasure> post(TypeValueDTO typeValue) {
        String json = converter.typeValueToJSON(typeValue);
        List<Treasure> treasures = null;

//        try {
//            URL url = new URL("http://treasure-generator.decoverri.com/mobile");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setRequestProperty("Content-type", "application/json");
//            connection.setDoOutput(true);
//            PrintStream stream = new PrintStream(connection.getOutputStream());
//            stream.print(json);
//
//            connection.connect();
//
//            String result = new Scanner(connection.getInputStream()).next();
//            treasures = converter.resultToTreasures(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        treasures = converter.resultToTreasures(null);
        return treasures;
    }
}
