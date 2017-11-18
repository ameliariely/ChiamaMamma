package com.ameliariely.chiama.ui.main

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ameliariely.chiama.ActivityRecognitionService
import com.ameliariely.chiama.R
import com.google.android.gms.location.ActivityRecognition


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpActivityRecognitionService()
    }

    private fun setUpActivityRecognitionService() {
        val activityRecognitionClient = ActivityRecognition.getClient(applicationContext)
        val intent = Intent(this, ActivityRecognitionService::class.java)
        val pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        activityRecognitionClient.requestActivityUpdates(300, pendingIntent)
    }
}
