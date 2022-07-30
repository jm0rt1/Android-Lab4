package com.example.lab4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SoupViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView pic;
    View view;

    public SoupViewHolder(View view)
    {
        super(view);
        name = (TextView) view.findViewById(R.id.soup_name);
        pic = (ImageView) view.findViewById(R.id.soup_image);
        this.view = view;
    }
}
