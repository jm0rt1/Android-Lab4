package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    public final String TAG = "RecyclerViewActivity";
    RecyclerView recyclerView;

    private ArrayList<SoupData> soupDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        try{
            soupDataList = new ArrayList<SoupData>();
            String[] names = getResources().getStringArray(R.array.soup_names);
            TypedArray images = getResources().obtainTypedArray(R.array.soup_images);
            Integer[] ids = new Integer[names.length];
            for(int i=0; i<images.length(); i++)
            {
                ids[i]=images.getResourceId(i,0);

                soupDataList.add(new SoupData(names[i], ids[i]));
            }

            final SimpleRecylcerAdapter adapter = new SimpleRecylcerAdapter(this,soupDataList);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());


        } catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
    }
}