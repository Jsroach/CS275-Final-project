package com.example.styledmap;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Path;

public class CrimeListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crime_list_activity);
        Log.e("AAA","======111111====");
        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            CrimeListFragment fragment = new CrimeListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, CrimeListFragment.TAG).commit();
        }
    }

    /** Shows the product detail fragment */
    public void show(Crime crime) {

        CrimeFragment crimeFragment = CrimeFragment.forCrime(crime.getId());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("crime")
                .replace(R.id.fragment_container,
                        crimeFragment, null).commit();
    }

    public static String namedSyncColumnBeanExample() {
        Path path = null;
        try {
            path = Helpers.namedColumnCsvPath();
        } catch (Exception ex) {
            Helpers.err(ex);
        }
        return BeanExamples.beanBuilderExample(path, NamedColumnBean.class).toString();
    }

    public static void main(String[] args) {
        namedSyncColumnBeanExample();
    }
}
