package com.example.styledmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "crime_table")
public class Crime{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Crime Id")
    public int mCrimeId;

    public int CrimeId(@NonNull int crimeid) {return this.mCrimeId = crimeid;}

    public int getCrimeId(){return this.mCrimeId;}

    @ColumnInfo(name = "Crime Type")
    public String mCrimeType;

    public String CrimeType(@NonNull String crimetype) {return this.mCrimeType = crimetype;}

    public String getCrimeType(){return this.mCrimeType;}


    @ColumnInfo(name = "Date Occurred")
    public String mDate;

     public String Date(@NonNull String date) {return this.mDate = date;}

    public String getDate(){return this.mDate;}

    @ColumnInfo(name = "Weapon")
    public String mWeapon;

    public String Weapon(@NonNull String weapon) {return this.mWeapon = weapon;}

    public String getWeapon(){return this.mWeapon;}

    @ColumnInfo(name = "Latitude")
    public float mLatitude;

    public Float Latitude(@NonNull float latitude) {return this.mLatitude = latitude;}

    public float getLatitude(){return this.mLatitude;}

    @ColumnInfo(name = "Longitude")
    public float mLongitude;

    public Float Longitude(@NonNull float longitude) {return this.mLongitude = longitude;}

    public float getLongitude(){return this.mLongitude;}

}
