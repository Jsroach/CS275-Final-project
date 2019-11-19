package com.example.styledmap;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.Date;
import java.util.List;

public class CrimeRepository {
    private CrimeDao mCrimeDao;
    private LiveData<List<CrimeDatabase>> mAllCrimes;


    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CrimeRepository(Application application) {
        CrimeRoomDatabase db = CrimeRoomDatabase.getDatabase(application);
        mCrimeDao = db.crimeDao();
        mAllCrimes = mCrimeDao.getAlphabetizedCrimes();
    }




    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<CrimeDatabase>> getAllCrimes() {
        return mAllCrimes;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    void insert(CrimeDatabase crime) {
        new insertAsyncTask(mCrimeDao).execute(crime);
    }

    private static class insertAsyncTask extends AsyncTask<CrimeDatabase, Void, Void> {

        private CrimeDao mAsyncTaskDao;

        insertAsyncTask(CrimeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final CrimeDatabase... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }



}
