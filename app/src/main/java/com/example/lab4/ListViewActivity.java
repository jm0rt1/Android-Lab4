package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    public final String TAG = "ListViewActivity";
    String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        try {
            //toolbar stuff
            Toolbar toolbar = findViewById(R.id.custom_toolbar);
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);

            //setting up the dynamic view
            names = getResources().getStringArray(R.array.soup_names);
            ArrayAdapter nameAdapter = ArrayAdapter.createFromResource(this, R.array.soup_names, R.layout.list_view_item);
            ListView listView = findViewById(R.id.recipe_list_view);
            listView.setAdapter(nameAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    Toast toast = Toast.makeText(ListViewActivity.this, "clicked " + names[position], Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        } catch (Exception ex){
            Log.e(TAG, ex.toString());
        }
    }
}