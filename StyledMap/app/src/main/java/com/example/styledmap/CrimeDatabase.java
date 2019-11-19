package com.example.styledmap;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Fts4
@Entity(tableName = "crime_table")
public class CrimeDatabase {
 /*   private Context mContext;
    // String csvFile = "C:\\Users\\AllBen\\Desktop\\CS275-Final-project\\StyledMap\\app\\src\\main\\res\\raw\\last6monthstrimmedbycrimenweapon.csv";

    public InputStream getCSV(Context context) {
        this.mContext = context;
        InputStream csv = context.getResources().openRawResource(R.raw.last6monthstrimmedbycrimenweapon);
        return csv;
    }*/
    @CsvBindByName(column = "rowid")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowid")
    public int rowid;

    public int rowid(int rowid) {
        return this.rowid = rowid;
    }

    public int getRowId() {
        return this.rowid;
    }

    @ColumnInfo(name = "Crime_Type")
    @CsvBindByName(column = "Crime_Type")
    public String mCrimeType;

    public String CrimeType(@NonNull String crime) {
        return this.mCrimeType = crime;
    }

    public String getCrimeType() {
        return this.mCrimeType;
    }
    @ColumnInfo(name = "Date_Occurred")
    @CsvBindByName(column = "Date_Occurred")
    @CsvDate("dd/mm/yyyy")
    public Date mDate;

    public Date Date(@NonNull Date date) {
        return this.mDate = date;
    }

    public Date getDate() {
        return this.mDate;
    }

    @ColumnInfo(name = "Weapon")
    @CsvBindByName(column = "Weapon")
    public String mWeapon;

    public String Weapon(@NonNull String weapon) {
        return this.mWeapon = weapon;
    }

    public String getWeapon() {
        return this.mWeapon;
    }

    @ColumnInfo(name = "Latitude")
    @CsvBindByName(column = "Latitude")
    public float mLatitude;

    public Float Latitude(@NonNull float latitude) {
        return this.mLatitude = latitude;
    }

    public float getLatitude() {
        return this.mLatitude;
    }

    @ColumnInfo(name = "Longitude")
    @CsvBindByName(column = "Longitude")
    public float mLongitude;

    public Float Longitude(@NonNull float longitude) {
        return this.mLongitude = longitude;
    }

    public float getLongitude() {
        return this.mLongitude;
    }
}









