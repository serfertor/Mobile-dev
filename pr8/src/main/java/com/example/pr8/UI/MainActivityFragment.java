package com.example.pr8.UI;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pr8.Domain.MAFViewModel;
import com.example.pr8.R;


public class MainActivityFragment extends Fragment {


    private static final String CHANNEL_ID = "1";
    private static final int PERMISSION_REQUEST_CODE = PackageManager.PERMISSION_GRANTED;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);
        MAFViewModel model = new ViewModelProvider(getActivity()).get(MAFViewModel.class);

        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.buttonSearch);
        ImageView logo = view.findViewById(R.id.imageView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainActivityFragment_to_listViewFragment);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainActivityFragment_to_recyclerViewFragment);
            }
        });
        EditText enter = (EditText) view.findViewById(R.id.enterSearch);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = enter.getText().toString();
                model.setSearch(txt);
                Navigation.findNavController(view).navigate(R.id.action_mainActivityFragment_to_searchFragment);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecretActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.small_logo2)
                        .setContentTitle("Hello!")
                        .setContentText("You can learn some new information")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                    notificationManager.notify(1, builder.build());
                    return;
                } else {
                    requestPermissions(new String[] {
                                    android.Manifest.permission.POST_NOTIFICATIONS, android.Manifest.permission.SYSTEM_ALERT_WINDOW
                            },
                            PERMISSION_REQUEST_CODE);
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
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
