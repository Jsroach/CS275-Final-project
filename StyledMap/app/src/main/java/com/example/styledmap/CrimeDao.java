package com.example.styledmap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CrimeDao{

    @Query("SELECT rowid,Crime_Type,Date_Occurred,Latitude,Longitude,Weapon from crime_table ORDER BY `Crime_Type` ASC")
    LiveData<List<CrimeDatabase>> getAlphabetizedCrimes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( CrimeDatabase crime);

   @Query("DELETE FROM crime_table")
    void deleteAll();
}
