package com.example.pr4;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecyclerViewFragment extends Fragment {
    private final static String TAG = "RecyclerViewFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] enter = getResources().getStringArray(R.array.list);
        ArrayList <String> items = new ArrayList<>(Arrays.asList(enter));
        CustomRecyclerAdapter.OnStateClickListener stateClickListener = new CustomRecyclerAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(String state, int position) {
                Log.d(TAG, "RecyclerView: Button " + position);
                Toast.makeText(getActivity(), "RecyclerView: Button " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        };
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(getActivity(), items, stateClickListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}