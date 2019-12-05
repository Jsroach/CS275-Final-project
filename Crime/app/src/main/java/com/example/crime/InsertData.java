package com.example.crime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class InsertData extends AppCompatActivity {
    EditText text1,text2,text3,text4,text5;
    TextView msg1,msg2,msg3,msg4,msg5,sdate;
    Button insertData,bdate;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        text1 = (EditText)findViewById(R.id.text1);
        text2 = (EditText)findViewById(R.id.text2);

        text3 = (EditText)findViewById(R.id.text3);

        text4 = (EditText)findViewById(R.id.text4);

        text5 = (EditText)findViewById(R.id.text5);

        msg1 = (TextView)findViewById(R.id.msg1);
        msg2 = (TextView)findViewById(R.id.msg2);

        msg3 = (TextView)findViewById(R.id.msg3);

        msg4 = (TextView)findViewById(R.id.msg4);

        msg5 = (TextView)findViewById(R.id.msg5);

        sdate=findViewById(R.id.sdate);
        bdate=findViewById(R.id.bdate);

        insertData = (Button)findViewById(R.id.insertData);

        bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean insertData = db.insertCrimeReportData(text1.getText().toString(),sdate.getText().toString(),text2.getText().toString(),text3.getText().toString(),text4.getText().toString(),text5.getText().toString());
                clearText();
                if(insertData == true)
                {

                    Toast.makeText(InsertData.this, "Data save successfully", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Toast.makeText(InsertData.this, "Data not save successfully", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
    void selectDate()
    {
         int mYear, mMonth, mDay, mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                     sdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();



    }
    public void clearText()
    {
        text1.getText().clear();
        text2.getText().clear();
        text3.getText().clear();
        text4.getText().clear();
        text5.getText().clear();

    }
}
