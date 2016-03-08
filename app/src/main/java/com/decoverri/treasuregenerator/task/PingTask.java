package com.decoverri.treasuregenerator.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by decoverri on 08/03/16.
 */
public class PingTask extends AsyncTask<Object, Object, Integer> {

    private Activity activity;

    public PingTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Integer doInBackground(Object[] params) {
        try {
            URL url = new URL("http://treasure-generator.decoverri.com/json/ping");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Log.i("DECO", ""+responseCode);
            return responseCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 500;
    }

    @Override
    protected void onPostExecute(Integer responseCode) {
        if(responseCode != 200){
            new AlertDialog.Builder(activity).setTitle("Dragon in the server!").setMessage("Sorry, this app won't work until we slay it.")
                    .setPositiveButton("Ok", null).show();
        }

    }
}
