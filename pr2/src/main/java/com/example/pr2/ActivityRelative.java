package com.example.pr2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRelative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        Bundle arguments = getIntent().getExtras();
        String enter = arguments.get("enter").toString();
        TextView text = (TextView) findViewById(R.id.text_under_cookie);
        text.setText(enter);
    }

}

