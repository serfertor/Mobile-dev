package com.example.pr7.Domain;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pr7.Data.MainRepository;
import com.example.pr7.R;
import com.example.pr7.SecretActivity;

public class MAFViewModel extends AndroidViewModel {
    MutableLiveData<String> search = new MutableLiveData<>();
    private static final String CHANNEL_ID = "1";
    private static final int PERMISSION_REQUEST_CODE = PackageManager.PERMISSION_GRANTED;
    @SuppressLint("StaticFieldLeak")
    Context context;

    public MAFViewModel(@NonNull Application application) {
        super(application);
        context = getApplication();
    }

    public void setSearch(String s){
        MainRepository.create("Search", s);
    }

    public LiveData<String> getSearch(){
        if (search == null) {
            search = new MutableLiveData<>(MainRepository.read("Search", ""));
        }
        return search;
    }

    public void notification(){
        Intent intent = new Intent(context, SecretActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "1")
                .setSmallIcon(R.drawable.small_logo2)
                .setContentTitle("Hello!")
                .setContentText("You can learn some new information")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        } else {
            requestPermissions(new String[] {
                            Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.SYSTEM_ALERT_WINDOW
                    },
                    PERMISSION_REQUEST_CODE);
        }
    }



    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE &&
                grantResults.length == 2) {
            if (
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &
                            grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
            }
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults
        );
    }
}
