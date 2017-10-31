package com.ameliariely.chiama

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.location.ActivityRecognition



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityRecognitionClient = ActivityRecognition.getClient(applicationContext)

        val intent = Intent(this, ActivityRecognitionService::class.java)
        val pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val task = activityRecognitionClient.requestActivityUpdates(300, pendingIntent)

    }
}
