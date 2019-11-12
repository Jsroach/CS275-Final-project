package com.example.styledmap;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewCrimeActivity extends AppCompatActivity {

   public static final String EXTRA_REPLY = "com.example.android.crimelistsql.REPLY";
    //public static final int EXTRA_REPLY = 1;
    private EditText mEditCrimeView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_crime);
        mEditCrimeView = findViewById(R.id.edit_crime);
        mEditCrimeView = findViewById(R.id.edit_date);
        mEditCrimeView = findViewById(R.id.edit_weapon);
        mEditCrimeView = findViewById(R.id.edit_latitude);
        mEditCrimeView = findViewById(R.id.edit_longitude);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditCrimeView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String crime = mEditCrimeView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, crime);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
