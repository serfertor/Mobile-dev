package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLinear extends AppCompatActivity {

    private String enters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liner_layout);
        Bundle arguments = getIntent().getExtras();
        String enter = arguments.get("enter").toString();
        enters = enter;
    }

    public String getEnters() {
        return enters;
    }
}