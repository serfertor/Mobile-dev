package com.example.pr8.UI;

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

import com.example.pr8.Domain.LVViewModel;
import com.example.pr8.R;

public class ResultListFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_list, container, false);
        LVViewModel lvViewModel = ViewModelProviders.of(getActivity()).get(LVViewModel.class);
        String answer = lvViewModel.getMove().getValue();
        TextView textView = (TextView) view.findViewById(R.id.listInput);
        textView.setText(answer);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
