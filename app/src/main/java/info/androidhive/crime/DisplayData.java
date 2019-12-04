package info.androidhive.crime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.checkinternet.R;

public class DisplayData extends AppCompatActivity {

    TextView msg1,msg2,msg3,msg4,msg5;
    DatabaseHelper db = new DatabaseHelper(this);
    Cursor cr;

    String m1 ="",m2="",m3="",m4="",m5="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        Intent intent = getIntent();
        m1 = intent.getStringExtra("m1");

        m2 = intent.getStringExtra("m2");
        m3 = intent.getStringExtra("m3");
        m4 = intent.getStringExtra("m4");
        m5 = intent.getStringExtra("m5");

        msg1 = (TextView)findViewById(R.id.msg1);
        msg2 = (TextView)findViewById(R.id.msg2);

        msg3 = (TextView)findViewById(R.id.msg3);

        msg4 = (TextView)findViewById(R.id.msg4);

        msg5 = (TextView)findViewById(R.id.msg5);

        msg1.setText("Crime id is : "+m1);
        msg2.setText("Crime type is : "+m2);
        msg3.setText("Weapon name is : "+m3);
        msg4.setText("Latitude is : "+m4);
        msg5.setText("Longtitude is : "+m5);
    }


}
