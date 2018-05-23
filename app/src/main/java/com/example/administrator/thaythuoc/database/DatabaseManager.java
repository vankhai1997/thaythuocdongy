package com.example.administrator.thaythuoc.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseManager {
    private Context context;
    private final String pathDb;
    private String DB_NAME = "dongy.sqlite";
    private SQLiteDatabase sqliteManager;
    private Cursor c;
    Database database;
    private int id;
    private String name;
    public  List<Database> databases;

    public  List<Database> getDatabases() {
        return databases;
    }

    public  void setDatabases(List<Database> databases) {
        this.databases = databases;
    }

    public DatabaseManager(Context context) {
        this.context = context;
        pathDb = Environment.getDataDirectory()
                + File.separator + "data"
                + File.separator + context.getPackageName()
                + File.separator + "database"
                + File.separator + DB_NAME;

    }

    private void coppyDB() {
        String path
                = Environment.getDataDirectory()
                //duong dan external cua toan bo app
                + File.separator + "data"
                + File.separator + context.getPackageName()
                //duong dan external cua app hien tai
                + File.separator + "database";
        new File(path).mkdir();
        File file = new File(pathDb);
        if (file.exists()) {
            return;
        }
        //copy
        AssetManager manager = context.getAssets();
        try {
            InputStream in = manager.open(DB_NAME);
            OutputStream out = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int le = in.read(b);
            while (le > -1) {
                out.write(b, 0, le);
                le = in.read(b);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        coppyDB();
        if (sqliteManager == null ||
                !sqliteManager.isOpen()) {
            sqliteManager = SQLiteDatabase
                    .openDatabase(pathDb, null,
                            SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDB() {
        if (sqliteManager != null &&
                sqliteManager.isOpen()) {
//            sqliteManager.close();
        }
    }

    public List<Database> databaseList() {
        databases = new ArrayList<>();
        openDB();
        //cau len sql

//        if (isCkeckAnswer() == true) {
//           number++;
//            Log.d("aaaaaaaaaaaaaaaa", "" + getNumber());
//        }


        c = sqliteManager.rawQuery(
                "SELECT * FROM Items",
                null);


        if (c != null) {
            int indexId = c.getColumnIndex("Idc");
            int iName = c.getColumnIndex("Name");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                id = c.getInt(indexId);
                name = c.getString(iName);

                database = new Database();
                database.setId(id);
                database.setName(name);
                databases.add(database);
                c.moveToNext();
            }
            c.close();
        }
        closeDB();
//        Log.d("rrr", "databaseList: "+databases.size());
        return databases;

    }

    public void getList(int number){
        databases= new ArrayList<>();
        c = sqliteManager.rawQuery(
                "SELECT * FROM Items where Idc ="+number,
                null);


        if (c != null) {
            int indexId = c.getColumnIndex("Idc");
            int iName = c.getColumnIndex("Name");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                id = c.getInt(indexId);
                name = c.getString(iName);

                database = new Database();
                database.setId(id);
                database.setName(name);
                databases.add(database);
                c.moveToNext();
            }
            c.close();
        }
        for (Database dt:databases
             ) {
            Log.d("aaa", "getList: "+dt.getName());
        }
        closeDB();
//        for (int i=0;i<databases.size();i++){
//            Log.d("aaa", "getListA: "+databases.get(i).getId());
//            if (databases.get(i).getId()!=number){
//                databases.remove(i);
////                String name =databases.get(i).getName();
////
////                database = new Database();
////                database.setName(name);
////                databases.add(database);
//            }
//        }
    }

}
