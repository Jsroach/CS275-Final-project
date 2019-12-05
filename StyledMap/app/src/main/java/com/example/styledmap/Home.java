package com.example.styledmap;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    DatabaseHelper sql;
    Button insertBtn,searchBtn;
    List<Crime> crs = new ArrayList<Crime>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sql=new DatabaseHelper(getApplicationContext());
        insertBtn = (Button)findViewById(R.id.insert);
        searchBtn = (Button)findViewById(R.id.search);



//sql.delete();

        crs=sql.fetchCrimes();
        if(crs.size()==0)
            ReadCSV();




        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,InsertData.class);
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,Search.class);
                Search.crs=crs;
                startActivity(intent);
            }
        });


    }

    void ReadCSV()
    {



        try {

            InputStream is = getApplication().getAssets().open("crime.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            String csvSplitBy = ",";

            String i="1";
            br.readLine();

            while ((line = br.readLine()) != null) {

                if(line.contains("\""))
                {
                    String[] record = line.split(csvSplitBy);
                    Crime cr = new Crime();
                    cr.setId(i);
                    cr.setDate(record[0]);
                    cr.setCrime_type(record[1]+", "+record[2]);
                    cr.setWeapon(record[3]);
                    cr.setLattitude(Double.parseDouble(record[4]));
                    cr.setLongitude(Double.parseDouble(record[5]));
                    crs.add(cr);
                    i=(Integer.parseInt(i)+1)+"";
                }
                else {

                    String[] record = line.split(csvSplitBy);
                    Crime cr = new Crime();
                    cr.setId(i);
                    cr.setDate(record[0]);
                    cr.setCrime_type(record[1]);
                    cr.setWeapon(record[2]);
                    cr.setLattitude(Double.parseDouble(record[3]));
                    cr.setLongitude(Double.parseDouble(record[4]));
                    crs.add(cr);
                    i=(Integer.parseInt(i)+1)+"";
                }
            }

            for(Crime c : crs)
            {
                sql.insertCrimeReportData(c.getId(),c.getDate(),c.getCrime_type(),c.getWeapon(),c.getLattitude()+"",c.getLongitude()+"");
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }






    }
}

