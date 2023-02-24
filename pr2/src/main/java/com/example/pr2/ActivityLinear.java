package com.example.pr2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLinear extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liner_layout);
        Button button1 = (Button)findViewById(R.id.prog_button);
        Button button2 = (Button)findViewById(R.id.decl_button);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        Bundle arguments = getIntent().getExtras();
        String enter = arguments.get("enter").toString();
        TextView text = (TextView) findViewById(R.id.linear);
        text.setText(enter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prog_button:
                Button button1 = (Button)findViewById(R.id.prog_button);
                button1.setText("Success!!");
                break;
            case R.id.decl_button:
                Button button2 = (Button)findViewById(R.id.decl_button);
                button2.setText("Success!!");
                break;
        }
    }
}