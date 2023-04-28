package com.example.pr8.UI;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pr8.Domain.WRViewModel;
import com.example.pr8.R;


public class WRFragment extends Fragment {

    private static final String CHANNEL_ID = "2";
    private static final int PERMISSION_REQUEST_CODE = PackageManager.PERMISSION_GRANTED;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_w_r, container, false);
        WRViewModel model = new ViewModelProvider(getActivity()).get(WRViewModel.class);
        LiveData<String> data = model.getData();
        LiveData<String> dataDB = model.getEnt();

        if ((ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) &
                (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[] {
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE
                    },
                    PERMISSION_REQUEST_CODE);
        }

        Button W1 = view.findViewById(R.id.W1);
        Button R1 = view.findViewById(R.id.R1);
        Button W2 = view.findViewById(R.id.W2);
        Button R2 = view.findViewById(R.id.R2);
        Button W3 = view.findViewById(R.id.W3);
        Button R3 = view.findViewById(R.id.R3);
        Button W4 = view.findViewById(R.id.W4);
        Button R4 = view.findViewById(R.id.R4);
        EditText name = view.findViewById(R.id.nameFile);
        EditText text = view.findViewById(R.id.textFile);
        TextView output = view.findViewById(R.id.out);

        W1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.writeAPS(getContext().getFilesDir().toString() + "/" + name.getText() + ".txt", String.valueOf(text.getText()));
            }
        });
        R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.readAPS(getContext().getFilesDir() + "/" + name.getText() + ".txt");
            }
        });
        W2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.writeES(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/" + name.getText() + ".txt", String.valueOf(text.getText()));
            }
        });
        R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.readES(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/" + name.getText() + ".txt");
            }
        });
        W3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.writeSP(String.valueOf(name.getText()), String.valueOf(text.getText()));
            }
        });
        R3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.readSP(String.valueOf(name.getText()));
            }
        });
        W4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.insertDB(String.valueOf(name.getText()), String.valueOf(text.getText()));
            }
        });
        R4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.readDB(String.valueOf(name.getText()));
            }
        });

        data.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                output.setText(s);
            }
        });

        dataDB.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String dbEntities) {
                output.setText(dbEntities);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE &&
                grantResults.length == 2) {
            if (
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &
                            grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
            }
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults
        );
    }

}