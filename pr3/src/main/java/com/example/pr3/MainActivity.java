package com.example.pr3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MenuLayoutFragment.OnFragmentToDataListener{

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String enter = intent.getStringExtra("message");
                    TextView textView = (TextView) findViewById(R.id.for_result);
                    textView.setText(enter);

                    /*if (enter != null){
                        Bundle bundle = new Bundle();
                        bundle.putString("key", enter);
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.menu, MenuLayoutFragment.class, bundle)
                                .commit();
                    }*/
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    @Override
    public void onFragmentToDataListener(String string) {
        Intent intent = new Intent(this, ResultActivity.class);
        mStartForResult.launch(intent);
    }
}

