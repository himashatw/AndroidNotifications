package com.example.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class MainActivity extends AppCompatActivity {

    Button btnNotifyHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotifyHome = findViewById(R.id.btnNotifyHome);

        btnNotifyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotification();
            }
        });

    }

    public void addNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            String CHANNEL_ID = "channel99";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            // Create an explicit intent for an Activity in your app
            // Create an explicit intent for an Activity in your app
            Intent intent = new Intent(this, NotificationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);



            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(012, builder.build());


        }
    }


}


