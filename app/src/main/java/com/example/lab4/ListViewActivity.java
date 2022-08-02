package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    public final String TAG = "ListViewActivity";
    String[] names;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //toolbar stuff
        Toolbar toolbar = (Toolbar)findViewById(R.id.custom_toolbar1);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //setting up the dynamic view
        names = getResources().getStringArray(R.array.soup_names);




        ArrayAdapter nameAdapter = ArrayAdapter.createFromResource(this, R.array.soup_names, R.layout.list_view_item);
//        ArrayAdapter nameAdapter = new ArrayAdapter<String>(this,R.layout.list_view_item, names);

        ListView listView = (ListView)findViewById(R.id.recipe_list_view);


        listView.setAdapter(nameAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Toast toast = Toast.makeText(ListViewActivity.this, "clicked ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}