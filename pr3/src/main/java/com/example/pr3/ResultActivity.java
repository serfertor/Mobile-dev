package com.example.pr3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity implements ResultLayoutFragment.OnFragmentToDataListener{

    private static final String TAG = "My app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
    }

    @Override
    public void onFragmentToDataListener(String string) {
        Intent data = new Intent();
        data.putExtra("message", string);
        setResult(1, data);
        finish();
    }
}