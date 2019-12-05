package info.androidhive.crime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    public static String Databasename = "crime_database";
    public static String crime_table = "crime_table";


    public static String col1_id = "id";
    public static String col2_crime_id = "crime_id";
    public static String col3_crime_type = "crime_type";
    public static String col4_weapon = "weapon";
    public static String col5_latitude = "latitude";
    public static String col6_longitude = "longitude";


    public DatabaseHelper(Context context) {
        super(context, Databasename, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + crime_table + "(id INTEGER PRIMARY KEY, crime_id TEXT , crime_type TEXT,weapon TEXT,latitude TEXT , longitude TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + crime_table);

        onCreate(sqLiteDatabase);
    }

    //=========================================================================================

    public boolean insertCrimeReportData(String crime_id, String crime_type, String weapon, String latitude, String longitude) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2_crime_id, crime_id);
        cv.put(col3_crime_type, crime_type);
        cv.put(col4_weapon, weapon);
        cv.put(col5_latitude, latitude);
        cv.put(col6_longitude, longitude);


        long result = sqLiteDatabase.insert(crime_table, null, cv);
        if (result == -1) {
            return false;
        }
        return true;
    }
//=========================================================================================

    public Cursor getAllCrimeData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from " + crime_table, null);
        return cr;
    }

    //==================================================================

    public Cursor getLastRecord()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+crime_table+ " order by " +col1_id+ " desc limit 1", null);
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