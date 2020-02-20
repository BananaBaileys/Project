package com.example.jasonyang.notificationtester;

import android.app.Notification;
import android.media.RingtoneManager;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;                  //shows the notification
    private EditText editTextTitle;                                         //creates an edit text object
    private EditText editTextMessage;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.tts = new TextToSpeech(this,this);

        notificationManager = NotificationManagerCompat.from(this);         //references the constructor to create a new notification manager object

        editTextTitle = findViewById(R.id.edit_text_title);                 //R.id.something means a view that is defined in any layout having id name
        editTextMessage = findViewById(R.id.edit_text_message);             //R is a class in android that are having the id's of all the view s
    }                                                                       //method that finds the view from the layout resource file

    public void sendOnChannel1(View v)
    {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);


        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)      //no semicolon right away
                .setSmallIcon(R.drawable.ic_sms_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_RECOMMENDATION)
                .setSound(uri)
                .build();

        notificationManager.notify(1, notification);        //give them different ids for different times, same notification same id

        tts.speak("PLEASE FOR THE LOVE OF GOD DO SOME EXERCISE", TextToSpeech.QUEUE_FLUSH, null);

    }

   /* public void onInit(int initStatus){
        this.tts.setLanguage(Locale.US);
    }*/

    public void sendOnChannel2(View v)
    {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();



        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)      //no semicolon right away
                .setSmallIcon(R.drawable.ic_sms_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .build();

        notificationManager.notify(2, notification);
    }
}
