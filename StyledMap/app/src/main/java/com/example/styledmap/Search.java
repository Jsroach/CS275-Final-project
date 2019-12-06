package com.example.styledmap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    static public  List<Crime> crs ;
    public List<Crime> temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.searchView);
        temp=new ArrayList<Crime>();
        final    DatabaseHelper dh=new DatabaseHelper(getApplicationContext());


        recyclerView   =  findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter

        final CustomAdapter customAdapter = new CustomAdapter(Search.this,crs,dh);
        recyclerView.setAdapter(customAdapter);

        // set the Adapter to RecyclerView



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                for(Crime c:crs)
                {
                    if(c.getCrime_type().contains(query))
                    {
                        temp.add(c);
                    }
                }
                final CustomAdapter ca = new CustomAdapter(Search.this,temp,dh);
                recyclerView.setAdapter(ca);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {


                return false;
            }
        });



    }
}
