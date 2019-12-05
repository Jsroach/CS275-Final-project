package info.androidhive.crime;

import android.content.Intent;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import info.androidhive.checkinternet.R;

public class Search extends AppCompatActivity
{

    DatabaseHelper db = new DatabaseHelper(this);
    Cursor cr;
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cr = db.getAllCrimeData();

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        list = new ArrayList<>();


        while (cr.moveToNext())
        {
            Log.e("aaaa","id==>"+cr.getString(1));
            list.add(cr.getString(1));

        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(Search.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(Search.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int value=i+1;
                String value1 = String.valueOf(value);
                String m1="",m2="",m3="",m4="",m5="";
                cr = db.getAllProgramContentData(value1);

                while (cr.moveToNext())
                {
                   m1 = cr.getString(1);
                    m2 = cr.getString(2);
                    m3 = cr.getString(3);
                    m4 = cr.getString(4);
                    m5 = cr.getString(5);
                }
                 Log.e("111","id==>"+m1);
                Log.e("22","id==>"+m2);
                Log.e("33","id==>"+m3);
                Log.e("44","id==>"+m4);
                Log.e("55","id==>"+m5);

                Intent intent = new Intent(Search.this,DisplayData.class);
                intent.putExtra("m1",m1);
                intent.putExtra("m2",m2);
                intent.putExtra("m3",m3);
                intent.putExtra("m4",m4);
                intent.putExtra("m5",m5);

                startActivity(intent);

            }
        });
    }
}
