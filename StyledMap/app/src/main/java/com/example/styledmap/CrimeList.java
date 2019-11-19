package com.example.styledmap;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CrimeList extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private CrimeViewModel mCrimeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final CrimeListAdapter adapter = new CrimeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mCrimeViewModel = new ViewModelProvider(this).get(CrimeViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mCrimeViewModel.getAllCrimes().observe(this, new Observer<List<CrimeDatabase>>() {
            @Override
            public void onChanged(@Nullable final List<CrimeDatabase> crimes) {
                // Update the cached copy of the words in the adapter.
               adapter.setCrimes(crimes);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
                Intent intent = new Intent(CrimeList.this, NewCrimeActivity.class);
               startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

          //Crime crime = new Crime(01, data.getStringExtra(NewCrimeActivity.EXTRA_REPLY),"Strong Arm",110,100);
         // mCrimeViewModel.insert(crime);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.app_name,
                    Toast.LENGTH_LONG).show();
        }
    }
}