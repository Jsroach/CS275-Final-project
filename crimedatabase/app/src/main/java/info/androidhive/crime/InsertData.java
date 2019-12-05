package info.androidhive.crime;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.checkinternet.R;

public class InsertData extends AppCompatActivity
{

    EditText text1,text2,text3,text4,text5;
    TextView msg1,msg2,msg3,msg4,msg5;
    Button insertData;
    DatabaseHelper db = new DatabaseHelper(this);
    Cursor cr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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


        insertData = (Button)findViewById(R.id.insertData);

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean insertData = db.insertCrimeReportData(text1.getText().toString(),text2.getText().toString(),text3.getText().toString(),text4.getText().toString(),text5.getText().toString());
                clearText();
                 if(insertData == true)
                 {

                     Toast.makeText(InsertData.this, "Data save successfully", Toast.LENGTH_SHORT).show();
                     getLastRecord();

                 }
                 else
                 {
                     Toast.makeText(InsertData.this, "Data not save successfully", Toast.LENGTH_SHORT).show();

                 }

            }
        });



    }

    public void clearText()
    {
        text1.getText().clear();
        text2.getText().clear();
        text3.getText().clear();
        text4.getText().clear();
        text5.getText().clear();

    }

    public void getLastRecord()
    {
        cr = db.getLastRecord();
        while (cr.moveToNext())
        {
           msg1.setText("Crime id is : "+cr.getString(1));
            msg2.setText("Crime type is : "+cr.getString(2));
            msg3.setText("Weapon name is : "+cr.getString(3));
            msg4.setText("Latitude is : "+cr.getString(4));
            msg5.setText("Longtitude is : "+cr.getString(5));
        }
    }
}
