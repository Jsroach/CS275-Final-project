package info.androidhive.crime;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.androidhive.checkinternet.R;

public class Home extends AppCompatActivity {

    Button insertBtn,searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        insertBtn = (Button)findViewById(R.id.insert);
        searchBtn = (Button)findViewById(R.id.search);

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
                startActivity(intent);
            }
        });


    }
}
