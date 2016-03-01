package com.decoverri.treasuregenerator.task;

import android.util.Log;

import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.TypeValueDTO;
import com.decoverri.treasuregenerator.util.JSONConverter;

import java.io.PrintStream;
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

    public List<Treasure> post(TypeValueDTO typeValue) {
        String params = "value="+typeValue.getValue().intValue()+"&letter="+typeValue.getTypeLetter();
        List<Treasure> treasures = null;

        try {
            URL url = new URL("http://treasure-generator.decoverri.com/android/generate");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            writer.print(params);
            writer.close();

            connection.connect();
            Log.i("DECO", connection.getContent().toString());
            String result = new Scanner(connection.getInputStream()).nextLine();
            treasures = converter.resultToTreasures(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return treasures;
    }
}
