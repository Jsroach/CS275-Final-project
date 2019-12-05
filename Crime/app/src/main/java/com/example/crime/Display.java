package com.example.crime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView msg1,msg2,msg3,msg4,msg5,msg6;
  //  DatabaseHelper db = new DatabaseHelper(this);
    Cursor cr;

    String m1 ="",m2="",m3="",m4="",m5="",m6="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        m1 = intent.getStringExtra("id");

        m2 = intent.getStringExtra("date");
        m3 = intent.getStringExtra("type");
        m4 = intent.getStringExtra("weapon");
        m5 = intent.getStringExtra("lat");
        m6 = intent.getStringExtra("lon");

        msg1 = (TextView)findViewById(R.id.msg1);
        msg2 = (TextView)findViewById(R.id.msg2);

        msg3 = (TextView)findViewById(R.id.msg3);

        msg4 = (TextView)findViewById(R.id.msg4);

        msg5 = (TextView)findViewById(R.id.msg5);
        msg6 = (TextView)findViewById(R.id.msg6);

        msg1.setText("Crime id is : "+m1);
        msg2.setText("Crime Date is : "+m2);
        msg3.setText("Crime type is : "+m3);
        msg4.setText("Weapon name is : "+m4);
        msg5.setText("Latitude is : "+m5);
        msg6.setText("Longtitude is : "+m6);
    }

}
