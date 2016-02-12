package com.decoverri.treasuregenerator.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.model.TreasureType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class TreasureTypeDao extends SQLiteOpenHelper {

    private static final String DATABASE = "Generator";
    private static final int VERSION = 3;

    private static final String TABLE = "TreasureType";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DRAWABLE = "drawable";

    public TreasureTypeDao(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                " " + COLUMN_DRAWABLE + " INTEGER);";
        db.execSQL(createTable);

        add(db, new TreasureType(R.drawable.coins));
        add(db, new TreasureType(R.drawable.gems));
        add(db, new TreasureType(R.drawable.art));
        add(db, new TreasureType(R.drawable.small_objects));
        add(db, new TreasureType(R.drawable.weapon_armor));
        add(db, new TreasureType(R.drawable.combatant));
        add(db, new TreasureType(R.drawable.spellcaster));
        add(db, new TreasureType(R.drawable.lair));
        add(db, new TreasureType(R.drawable.hoard));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Treasure");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void add(SQLiteDatabase db, TreasureType type){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DRAWABLE, type.getDrawable());
        db.insert(TABLE, null, values);
    }

    public List<TreasureType> list(){
        ArrayList<TreasureType> types = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE + ";", null);
        while(c.moveToNext()){
            TreasureType type = new TreasureType(c.getInt(c.getColumnIndex(COLUMN_DRAWABLE)));
            type.setId(c.getLong(c.getColumnIndex(COLUMN_ID)));
            types.add(type);
        }
        c.close();
        return types;
    }
}
