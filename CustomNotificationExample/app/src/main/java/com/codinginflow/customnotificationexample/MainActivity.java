package com.codinginflow.customnotificationexample;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import static com.codinginflow.customnotificationexample.App.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void showNotification(View v) {
        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collapsed);
        RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.notification_expanded);
        if (collapsedView != null) {
            Log.i("collapse view", "success");
        } else {
            Log.i("collapse view", "fail");
        }
        if (expandedView != null) {
            Log.i("expanded view", "success");
        } else {
            Log.i("expanded view", "fail");
        }

        Intent clickIntent = new Intent(this, NotificationReceiver.class);
        Intent playPauseIntent = new Intent(this, playPauseReceiver.class);
        if (clickIntent != null) {
            Log.i("clickIntent", "success");
        } else {
            Log.i("clickIntent", "fail");
        }
        if (playPauseIntent != null) {
            Log.i("playPauseIntent", "success");
        } else {
            Log.i("playPauseIntent", "fail");
        }

        PendingIntent clickPendingIntent = PendingIntent.getBroadcast(this,
                0, clickIntent, 0);
        PendingIntent pendingPlayPauseIntent = PendingIntent.getBroadcast(this, 0, playPauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (clickPendingIntent != null) {
            Log.i("clickPendingIntent", "success");
        } else {
            Log.i("clickPendingIntent", "fail");
        }
        if (pendingPlayPauseIntent != null) {
            Log.i("pendingPlayPauseIntent", "success");
        } else {
            Log.i("pendingPlayPauseIntent", "fail");
        }

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!");

        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.lotti3);
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent);
        expandedView.setOnClickPendingIntent(R.id.button, pendingPlayPauseIntent);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();

        notificationManager.notify(1, notification);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();

        showNotification();

    }

    public void showNotification() {
        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collapsed);
        RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.notification_expanded);

        Intent clickIntent = new Intent(this, NotificationReceiver.class);
        Intent playPauseIntent = new Intent(this, playPauseReceiver.class);

        PendingIntent clickPendingIntent = PendingIntent.getBroadcast(this,
                0, clickIntent, 0);
        PendingIntent pendingPlayPauseIntent = PendingIntent.getBroadcast(this, 0, playPauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!");

        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.lotti3);
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent);
        expandedView.setOnClickPendingIntent(R.id.button, pendingPlayPauseIntent);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();

        notificationManager.notify(1, notification);
    }



}
