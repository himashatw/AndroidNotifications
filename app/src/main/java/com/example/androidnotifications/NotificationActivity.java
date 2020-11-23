package com.example.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    TextView tvNotificationMSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        tvNotificationMSG = findViewById(R.id.tvNotificationMSG);
        String notificationMSG = getIntent().getStringExtra("Message");
        Toast.makeText(this, "Message : "+notificationMSG, Toast.LENGTH_SHORT).show();
        tvNotificationMSG.setText(notificationMSG);
    }
}