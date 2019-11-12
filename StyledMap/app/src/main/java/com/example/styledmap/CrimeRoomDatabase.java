package com.example.styledmap;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

@Database(entities = {Crime.class}, version = 1,  exportSchema = false)
 public abstract class CrimeRoomDatabase extends RoomDatabase {
     public abstract CrimeDao crimeDao();
    private static volatile CrimeRoomDatabase INSTANCE;
    static CrimeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CrimeRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CrimeRoomDatabase.class, "crime_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            //new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final CrimeDao mDao;

        PopulateDbAsync(CrimeRoomDatabase db) {
            mDao = db.crimeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            Crime crime = new Crime(01,"Robbery","Strong Arm",110, 100 );
            mDao.insert(crime);
            crime = new Crime(02,"Robbery","Strong Arm",110, 100);
            mDao.insert(crime);
            return null;
        }
    }
    /* public class FeedReaderDbHelper extends SQLiteOpenHelper {
         // If you change the database schema, you must increment the database version.
         public static final int DATABASE_VERSION = 1;
         public static final String DATABASE_NAME = "FeedReader.db";
         private static final String SQL_CREATE_ENTRIES =
                 "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                         FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                         FeedReaderContract.FeedEntry.COLUMN_NAME_DATE + " TEXT," +
                         FeedReaderContract.FeedEntry.COLUMN_NAME_TYPE + " TEXT," +
                         FeedReaderContract.FeedEntry.COLUMN_NAME_WEAPON + " TEXT," +
                         FeedReaderContract.FeedEntry.COLUMN_NAME_LAT + " TEXT," +
                         FeedReaderContract.FeedEntry.COLUMN_NAME_LON + " TEXT)";

         private static final String SQL_DELETE_ENTRIES =
                 "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

         public final class FeedReaderContract {
             // To prevent someone from accidentally instantiating the contract class,
             // make the constructor private.
             private FeedReaderContract() {
             }

              Inner class that defines the table contents
             public class FeedEntry implements BaseColumns {
                 public static final String TABLE_NAME = "Crimes";
                 public static final String COLUMN_NAME_DATE = "Date Occurred";
                 public static final String COLUMN_NAME_TYPE = "Crime Type";
                 public static final String COLUMN_NAME_WEAPON = "Weapon Desc";
                 public static final String COLUMN_NAME_LAT = "Latitude";
                 public static final String COLUMN_NAME_LON = "Longitude";
             }


         }


         public FeedReaderDbHelper(Context context) {
             super(context, DATABASE_NAME, null, DATABASE_VERSION);
         }

         public void onCreate(SQLiteDatabase db) {
             db.execSQL(SQL_CREATE_ENTRIES);
         }


         public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             // This database is only a cache for online data, so its upgrade policy is
             // to simply to discard the data and start over
             db.execSQL(SQL_DELETE_ENTRIES);
             onCreate(db);
         }

         public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             onUpgrade(db, oldVersion, newVersion);
         }
     } */





/*     FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());

     // Gets the data repository in write mode
     ;
     SQLiteDatabase db = dbHelper.getWritableDatabase();
     // Create a new map of values, where column names are the keys
     ContentValues values = new ContentValues();
    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE);
    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE);

     // Insert the new row, returning the primary key value of the new row
  //   long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values); */

}

/*
    //SQLiteDatabase db = dbHelper.getReadableDatabase();

    // Define a projection that specifies which columns from the database
// you will actually use after this query.
    String[] projection = {
            BaseColumns._ID,
            FeedReaderDbHelper.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
            FeedReaderDbHelper.FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
    };

    // Filter results WHERE "title" = 'My Title'
    String selection = FeedReaderDbHelper.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
    String[] selectionArgs = { "My Title" };

    // How you want the results sorted in the resulting Cursor
    String sortOrder =
            FeedReaderDbHelper.FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

    Cursor cursor = db.query(
            FeedReaderDbHelper.FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            selection,              // The columns for the WHERE clause
            selectionArgs,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
    );

        List itemIds = new ArrayList<>();
    while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedEntry._ID));
            itemIds.add(itemId);
        }
    cursor.close();*/



