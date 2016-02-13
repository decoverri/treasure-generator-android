package com.decoverri.treasuregenerator.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class PricesDao extends SQLiteOpenHelper {

    public PricesDao(Context context) {
        super(context, "Generator", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Double> getPrices(long id) {
        return null;
    }
}
