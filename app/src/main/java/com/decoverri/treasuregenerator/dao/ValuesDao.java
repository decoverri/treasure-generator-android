package com.decoverri.treasuregenerator.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class ValuesDao extends SQLiteOpenHelper {

    public ValuesDao(Context context) {
        super(context, "Generator", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Double> getValues(long id) {
        return new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
    }
}
