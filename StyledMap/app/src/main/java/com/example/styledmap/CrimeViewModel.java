package com.example.styledmap;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.FileReader;

import java.util.List;

public class CrimeViewModel extends AndroidViewModel {
   private CrimeRepository mRepository;

    private LiveData<List<CrimeDatabase>> mAllCrimes;

    public CrimeViewModel(Application application) {
        super(application);
        mRepository = new CrimeRepository(application);
        mAllCrimes = mRepository.getAllCrimes();
    }

    LiveData<List<CrimeDatabase>> getAllCrimes() {
        return mAllCrimes;
    }
    public void insert(CrimeDatabase crime) { mRepository.insert(crime);}

    }
