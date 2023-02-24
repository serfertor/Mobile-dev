package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "My app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        Button button = (Button) findViewById(R.id.send_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText enter = (EditText) findViewById(R.id.result_editText);
                String text = String.valueOf(enter.getText());
                Log.w(TAG, text);
                Intent data = new Intent();
                data.putExtra("message", text);
                setResult(1, data);
                finish();
            }
        });
    }
}