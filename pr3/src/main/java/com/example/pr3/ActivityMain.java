package com.example.pr3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class ActivityMain extends AppCompatActivity {

    private String enters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle arguments = getIntent().getExtras();
        String enter = arguments.get("enter").toString();
        enters = enter;
    }

    protected String getEnters(){
        return enters;
    }
}
