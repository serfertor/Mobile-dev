package com.example.pr7;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewFragment extends Fragment {

    private final static String TAG = "ListViewFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.listView1);

        String[] enter = getResources().getStringArray(R.array.list);

        ArrayList <String> names = new ArrayList<>(Arrays.asList(enter));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(),
                R.layout.custom_list, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new
            AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                {
                    Log.d(TAG, "ListView: Button " + position);
                    Toast.makeText(getActivity(), "ListView: Button " + (position + 1), Toast.LENGTH_SHORT).show();
                }
            });
    }

}