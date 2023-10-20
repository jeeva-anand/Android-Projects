package com.example.explicitintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLConnection extends SQLiteOpenHelper {

    private final static String DBNAME =  "Database.db";
    public SQLConnection(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table todo(id integer PRIMARY KEY AUTOINCREMENT,name text, descr text)");
    }


    public boolean insertTodo(String taskName, String desc){
        ContentValues cv = new ContentValues();
        cv.put("name",taskName);
        cv.put("descr",desc);
        return getWritableDatabase().insert("todo",null,cv) != -1;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }

    public List<Todo> readToDo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM todo", null);
        List<Todo> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
          while(cursor.moveToNext()){
                list.add(new Todo(cursor.getString(1),cursor.getString(2)));
            }

        }
        return list;

    }
}
