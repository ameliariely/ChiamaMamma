package com.ameliariely.chiama

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.android.gms.location.ActivityRecognition



class MainActivity : AppCompatActivity() {

    private lateinit var sendSmsButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpActivityRecognitionService()
        sendSmsButton = findViewById(R.id.send_sms_btn)
        sendSmsButton.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "9192604264", null))) }
    }

    private fun setUpActivityRecognitionService() {
        val activityRecognitionClient = ActivityRecognition.getClient(applicationContext)
        val intent = Intent(this, ActivityRecognitionService::class.java)
        val pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val task = activityRecognitionClient.requestActivityUpdates(300, pendingIntent)
    }
}
