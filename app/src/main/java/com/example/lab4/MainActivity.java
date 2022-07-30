package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            setSupportActionBar(findViewById(R.id.custom_toolbar));
            TextView longPressMe = findViewById(R.id.long_press_me);
            registerForContextMenu(longPressMe);

            Button recyclerButton = findViewById(R.id.recycler_view_button);
            recyclerButton.setOnClickListener(this::recyclerView);
        }
        catch(Exception ex){
            Log.e(TAG, ex.toString());
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.like:
                Toast toast = Toast.makeText(getApplicationContext(),"Like Clicked", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.two:
                toast = Toast.makeText(getApplicationContext(),"two Clicked", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.three:
                toast = Toast.makeText(getApplicationContext(),"three Clicked", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        ConstraintLayout constraintLayout = findViewById(R.id.main_activity_constraint_layout);
        switch(item.getItemId()){

            case R.id.red:
                constraintLayout.setBackgroundColor(Color.parseColor("#ff0000"));
                return true;
            case R.id.white:
                constraintLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                return true;
            case R.id.blue:
                constraintLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    public void recyclerView(View view)
    {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}