package com.decoverri.treasuregenerator.client;

import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.dto.TypeValue;
import com.decoverri.treasuregenerator.util.JSONConverter;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Created by decoverri on 29/02/16.
 */
public class LootClient {

    private JSONConverter converter;

    public LootClient() {
        converter = new JSONConverter();
    }

    public List<Treasure> post(TypeValue typeValue) {
        String params = "value="+typeValue.getValue().intValue()+"&letter="+typeValue.getTypeLetter();
        List<Treasure> treasures = null;

        try {
            URL url = new URL("http://treasure-generator.decoverri.com/json/generate");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            writer.print(params);
            writer.close();

            connection.connect();
            String result = new Scanner(connection.getInputStream()).nextLine();
            treasures = converter.resultToTreasures(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return treasures;
    }
}
