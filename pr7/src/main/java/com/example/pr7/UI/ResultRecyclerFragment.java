package com.example.pr7.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.pr7.Domain.LVViewModel;
import com.example.pr7.Domain.RVViewModel;
import com.example.pr7.R;

public class ResultRecyclerFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_recycler, container, false);
        RVViewModel lvViewModel = ViewModelProviders.of(getActivity()).get(RVViewModel.class);
        String answer = lvViewModel.getMove().getValue();
        TextView textView = (TextView) view.findViewById(R.id.recyclerInput);
        textView.setText(answer);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
