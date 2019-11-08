package com.example.styledmap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CrimeDao{

    @Query("SELECT * from crime_table ORDER BY `Crime Id` ASC")
    LiveData<List<Crime>> getAlphabetizedCrimes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( Crime crime);

   @Query("DELETE FROM crime_table")
    void deleteAll();
}
