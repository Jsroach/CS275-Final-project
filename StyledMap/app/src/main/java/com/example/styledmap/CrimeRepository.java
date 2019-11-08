package com.example.styledmap;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CrimeRepository {
    private CrimeDao mCrimeDao;
    private LiveData<List<Crime>> mAllCrimes;

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
    LiveData<List<Crime>> getAllCrimes() {
        return mAllCrimes;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    void insert(Crime crime) {
        new insertAsyncTask(mCrimeDao).execute(crime);
    }

    private static class insertAsyncTask extends AsyncTask<Crime, Void, Void> {

        private CrimeDao mAsyncTaskDao;

        insertAsyncTask(CrimeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Crime... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
