package com.example.pr4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final ArrayList<String> items;

    interface OnStateClickListener{
        void onStateClick(String state, int position);
    }

    private final OnStateClickListener onClickListener;

    CustomRecyclerAdapter(Context context, ArrayList<String> items, OnStateClickListener onClickListener) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list, parent,
                false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CustomRecyclerAdapter.ViewHolder holder, int position) {
        String item = items.get(position);
        holder.text.setText(item);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView text;
        ViewHolder(View view){
            super(view);
            text = view.findViewById(R.id.textView);
        }
    }
}

