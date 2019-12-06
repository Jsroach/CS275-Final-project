package com.example.styledmap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    public static String Databasename = "crime_database";
    public static String crime_table = "crime_table";


    public static String col1_id = "id";
    public static String col2_date = "crime_id";
    public static String col3_crime_type = "crime_type";
    public static String col4_weapon = "weapon";
    public static String col5_latitude = "latitude";
    public static String col6_longitude = "longitude";


    public DatabaseHelper(Context context) {
        super(context, Databasename, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + crime_table + "(id TEXT PRIMARY KEY,crime_date TEXT, crime_type TEXT,weapon TEXT,latitude TEXT , longitude TEXT)");

    }

    public  void create()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.execSQL("create table " + crime_table + "(id TEXT PRIMARY KEY,crime_date TEXT, crime_type TEXT,weapon TEXT,latitude TEXT , longitude TEXT)");
    }
    public  void delete()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.execSQL("delete from crime_table");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + crime_table);

        onCreate(sqLiteDatabase);
    }

    //=========================================================================================

    public boolean insertCrimeReportData(String crime_id, String crime_date, String crime_type, String weapon, String latitude, String longitude) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1_id, crime_id);
        cv.put(col2_date, crime_date);
        cv.put(col3_crime_type, crime_type);
        cv.put(col4_weapon, weapon);
        cv.put(col5_latitude, latitude);
        cv.put(col6_longitude, longitude);

        String type=crime_type.replace("\"","");

        try {
            sqLiteDatabase.execSQL("insert into crime_table values ('" + crime_id + "','" + crime_date + "','" + type + "','" + weapon + "','" + latitude + "','" + longitude + "')");
            return  true;
        }catch (Exception e)
        {
            return  false;
        }


    }
    //=========================================================================================
    public List<Crime> fetchCrimes()
    {
        List<Crime> crs = new ArrayList<Crime>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + crime_table+" order by crime_date asc", null);

        if (cr.moveToFirst()) {
            do {

                Crime c=new Crime();
                c.setId(cr.getString(0));
                c.setDate(cr.getString(1));
                c.setCrime_type(cr.getString(2));
                c.setWeapon(cr.getString(3));
                c.setLattitude(Double.parseDouble(cr.getString(4)));
                c.setLongitude(Double.parseDouble(cr.getString(5)));
                crs.add(c);

            } while (cr.moveToNext());


        }


        return  crs;
    }

    public void deleteRow(String i)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from crime_table where id='"+i+"'");
    }
    public Cursor getAllCrimeData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from " + crime_table, null);
        return cr;
    }

    //==================================================================

    public Cursor getLastRecord()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+crime_table+ "", null);
        return cr;
    }
    //===============================================================================

    public Cursor getAllProgramContentData(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+crime_table+" where "+col1_id+" = ?",new String[] {id},null);
        return cr;
    }
}
