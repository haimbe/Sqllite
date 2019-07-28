package com.example.testsqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Game.db";
    private static final int DATABASE_VERSION = 1;

public DatabaseManager(Context context){
    super( context, DATABASE_NAME, null, DATABASE_VERSION);
}


    @Override
    public void onCreate(SQLiteDatabase db) {
    String strSql = "create table T_Scores("
            +" idScore integer primary key autoincrement,"
            +" name tewt not null,"
            +" score integer not null,"
            +" when_integer not null"
            +")";
    db.execSQL( strSql);
    Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    String strSql = "drop table T_Scores";
    db.execSQL( strSql);
    this.onCreate(db);
    Log.i("DATABASE","onUpgrade invoked");

    }

    public void insertScore(String name, int score){
    name = name.replace("'","''");
    String strSql = "insert into T_Scores (name, score, when_) values('"
            +name+"',"+score+","+new Date().getTime()+")";
    this.getWritableDatabase().execSQL(strSql);
    Log.i("DATABASE","insertScore invoked");
    }
}
