package com.example.admin.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Database extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "sample_db";
    private static final String TABLE_NAME="Location";
    public static final String NAME1="Latitude";
    public static final String NAME2="Longitude";
    public Database(Context context) {
        super(context,DATABASE_NAME,null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+ "("

                + NAME1 + " DOUBLE,"

                + NAME2 + " DOUBLE"

                + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
    public void insert(double lat, double lon) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME1, lat);

        contentValues.put(NAME2, lon);
        sqLiteDatabase.insert(TABLE_NAME,null, contentValues);
    }
    public ArrayList getDataFromDataBase() {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ArrayList data = new ArrayList();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from Location",null);

        if (cursor != null && cursor.moveToFirst()){



            while(!cursor.isAfterLast()){

                //ArrayList arrayList = new ArrayList();

                //arrayList.add(Integer.parseInt(NAME), cursor.getString(cursor.getColumnIndex(NAME)));

                data.add(cursor.getString(0));

                cursor.moveToNext();

            }

        }

        return data;
    }

}
