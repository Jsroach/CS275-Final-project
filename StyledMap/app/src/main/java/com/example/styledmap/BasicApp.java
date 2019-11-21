package com.example.styledmap;

import android.app.Application;

public class BasicApp extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public CrimeRoomDatabase getDatabase() {
        return CrimeRoomDatabase.getInstance(this, mAppExecutors);
    }

    public CrimeRepository getRepository() {
        return CrimeRepository.getInstance(getDatabase());
    }
}