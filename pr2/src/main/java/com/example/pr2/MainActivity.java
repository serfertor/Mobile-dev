package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "My app";

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String enter = intent.getStringExtra("message");
                    TextView text = (TextView) findViewById(R.id.for_result);
                    text.setText(enter);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        Button button2 = (Button)findViewById(R.id.button_2);
        Button button3 = (Button)findViewById(R.id.button_3);
        Button button4 = (Button)findViewById(R.id.button_4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                Intent intent1 = new Intent(this, ActivityMain.class);
                EditText text1 = (EditText) findViewById(R.id.entering_text);
                intent1.putExtra("enter", text1.getText());
                startActivity(intent1);
                break;
            case R.id.button_2:
                Intent intent2 = new Intent(this, ActivityLinear.class);
                EditText text2 = (EditText) findViewById(R.id.entering_text);
                intent2.putExtra("enter", text2.getText());
                startActivity(intent2);
                break;
            case R.id.button_3:
                Intent intent3 = new Intent(this, ActivityRelative.class);
                EditText text3 = (EditText) findViewById(R.id.entering_text);
                intent3.putExtra("enter", text3.getText());
                startActivity(intent3);
                break;
            case R.id.button_4:
                Intent intent4 = new Intent(this, ResultActivity.class);
                EditText text4 = (EditText) findViewById(R.id.entering_text);
                intent4.putExtra("enter", text4.getText());
                Log.w(TAG, "Click button");
                mStartForResult.launch(intent4);
        }
    }
}