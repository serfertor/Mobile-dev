package com.example.pr3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRelative extends AppCompatActivity {

    private String enters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        Bundle arguments = getIntent().getExtras();
        String enter = arguments.get("enter").toString();
        enters = enter;
    }

    public String getEnters() {
        return enters;
    }
}

