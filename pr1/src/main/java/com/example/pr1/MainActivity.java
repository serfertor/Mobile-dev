package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "My app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        String text = "On create TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on create");
        Log.w(TAG, "Warning message on create");
        Log.i(TAG, "Information message on create");
        Log.d(TAG, "Debug message on create");
        Log.v(TAG, "Verbose message on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        String text = "On start TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on start");
        Log.w(TAG, "Warning message on start");
        Log.i(TAG, "Information message on start");
        Log.d(TAG, "Debug message on start");
        Log.v(TAG, "Verbose message on start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Context context = getApplicationContext();
        String text = "On stop TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on stop");
        Log.w(TAG, "Warning message on stop");
        Log.i(TAG, "Information message on stop");
        Log.d(TAG, "Debug message on stop");
        Log.v(TAG, "Verbose message on stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Context context = getApplicationContext();
        String text = "On destroy TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on destroy");
        Log.w(TAG, "Warning message on destroy");
        Log.i(TAG, "Information message on destroy");
        Log.d(TAG, "Debug message on destroy");
        Log.v(TAG, "Verbose message on destroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Context context = getApplicationContext();
        String text = "On pause TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on pause");
        Log.w(TAG, "Warning message on pause");
        Log.i(TAG, "Information message on pause");
        Log.d(TAG, "Debug message on pause");
        Log.v(TAG, "Verbose message on pause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        String text = "On resume TOAST";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.e(TAG, "Error message on resume");
        Log.w(TAG, "Warning message on resume");
        Log.i(TAG, "Information message on resume");
        Log.d(TAG, "Debug message on resume");
        Log.v(TAG, "Verbose message on resume");
    }
}