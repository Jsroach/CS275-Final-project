package com.example.styledmap;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCrimeActivity extends AppCompatActivity {

   public static final String EXTRA_REPLY = "com.example.android.crimelistsql.REPLY";
    //public static final int EXTRA_REPLY = 1;
    private EditText mEditCrimeViewType;
    private EditText mEditCrimeViewDate;
    private EditText mEditCrimeViewWeapon;
    private EditText mEditCrimeViewLatitude;
    private EditText mEditCrimeViewLongitude;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_crime);
        mEditCrimeViewType = findViewById(R.id.edit_crimetype);
        mEditCrimeViewDate = findViewById(R.id.edit_date);
        mEditCrimeViewWeapon = findViewById(R.id.edit_weapon);
        mEditCrimeViewLatitude = findViewById(R.id.edit_latitude);
        mEditCrimeViewLongitude = findViewById(R.id.edit_longitude);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditCrimeViewType.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {

                    String crimeType = mEditCrimeViewType.getText().toString();
                    String crimeDate = mEditCrimeViewDate.getText().toString();
                    String crimeWeapon = mEditCrimeViewWeapon.getText().toString();
                    String crimeLatitude = mEditCrimeViewLatitude.getText().toString();
                    String crimeLongitude = mEditCrimeViewLongitude.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, crimeType);
                    replyIntent.putExtra(EXTRA_REPLY, crimeDate);
                    replyIntent.putExtra(EXTRA_REPLY, crimeWeapon);
                    replyIntent.putExtra(EXTRA_REPLY, crimeLatitude);
                    replyIntent.putExtra(EXTRA_REPLY, crimeLongitude);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
