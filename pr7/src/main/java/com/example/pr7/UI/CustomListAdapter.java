package com.example.pr7.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pr7.R;

import java.util.ArrayList;


public class CustomListAdapter extends ArrayAdapter <String> {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<String> items;
    public CustomListAdapter(Context context, int resource,
                             ArrayList<String> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View view=inflater.inflate(this.layout, parent, false);

        TextView text = (TextView) view.findViewById(R.id.textView);

        String item = items.get(position);
        text.setText(item);

        return view;
    }
}