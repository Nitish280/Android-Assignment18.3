package com.example.lenovo.android183;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //creating Method sendInboxStyleNotification()
    public void sendInboxStyleNotification(View view) {
        //creating object of pendingIntent
        PendingIntent pendingIntent = getPendingIntent();
        //Creating Builder for Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //Setting Title
                .setContentTitle("EVENT DETAIL")
                //Setting Text
                .setContentText("Inbox Style notification!!")
                //Setting Icon
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new NotificationCompat.InboxStyle(builder)
                    //adding Some Notification
                    .addLine("Helloo..!").addLine("How are you?")
                    .addLine("HIII !!").addLine("i am fine...")
                    .addLine("what about you? all is well?")
                    .addLine("Yes, every thing is all right..")
                    .build();
            // Put the auto cancel notification flag
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            //creating Object NotificationManager
            NotificationManager notificationManager = getNotificationManager();
            notificationManager.notify(0, notification);
        }
    }
    //Creating PendingIntent Method()
    public PendingIntent getPendingIntent() {
        return PendingIntent.getActivity(this, 0, new Intent(this,
                HandleNotificationActivity.class), 0);
    }
    //creating getNotificationManager() for getting the Notification
    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

}
