package com.example.pr7.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr7.Domain.RVViewModel;
import com.example.pr7.R;

import java.util.ArrayList;
import java.util.Arrays;

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
        RVViewModel rvViewModel = new ViewModelProvider(getActivity()).get(RVViewModel.class);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] enter = getResources().getStringArray(R.array.list);
        ArrayList <String> items = new ArrayList<>(Arrays.asList(enter));
        CustomRecyclerAdapter.OnStateClickListener stateClickListener = new CustomRecyclerAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(String state, int position) {
                rvViewModel.setMove(String.valueOf(position-1));
                Navigation.findNavController(rootView).navigate(R.id.action_recyclerViewFragment_to_resultRecyclerFragment);;
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
