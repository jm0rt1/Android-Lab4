package com.example.lab4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleRecylcerAdapter extends RecyclerView.Adapter<SoupViewHolder> {

    List<SoupData> data;
    Context c;

    public SimpleRecylcerAdapter(Context c, List<SoupData> list){
        data = list;
        this.c = c;
    }

    @Override
    public SoupViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.recipecard,parent,false);
        SoupViewHolder soupViewHolder = new SoupViewHolder(v);
        return soupViewHolder;

    }

    @Override
    public void onBindViewHolder(final SoupViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(data.get(position).name);
        holder.pic.setImageResource(data.get(position).image);
        holder.view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(c.getApplicationContext(),"clicked "+data.get(position).name, Toast.LENGTH_SHORT);
                toast.show();
            }


        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
