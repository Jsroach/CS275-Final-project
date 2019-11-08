package com.example.styledmap;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CrimeViewModel extends AndroidViewModel {
   private CrimeRepository mRepository;

    private LiveData<List<Crime>> mAllCrimes;

    public CrimeViewModel(Application application) {
        super(application);
        mRepository = new CrimeRepository(application);
        mAllCrimes = mRepository.getAllCrimes();
    }

    LiveData<List<Crime>> getAllCrimes() {
        return mAllCrimes;
    }
    public void insert(Crime crime) { mRepository.insert(crime);}

    }
