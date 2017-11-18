package com.ameliariely.chiama

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.support.v4.app.JobIntentService
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import com.ameliariely.chiama.utils.NotificationHelper
import com.google.android.gms.location.ActivityRecognitionResult
import com.google.android.gms.location.DetectedActivity

class ActivityRecognitionService : JobIntentService() {

    private lateinit var notifcationHelper: NotificationHelper

    override fun onCreate() {
        super.onCreate()
        notifcationHelper = NotificationHelper(applicationContext)
    }

    override fun onHandleWork(intent: Intent) {
        if (!ActivityRecognitionResult.hasResult(intent)) {
            return
        }
        val activities = ActivityRecognitionResult.extractResult(intent).probableActivities

        for (activity in activities) {

            when (activity.getType()) {
                DetectedActivity.IN_VEHICLE -> {
                    Log.e("ActivityRecogition", "In Vehicle: " + activity.getConfidence())
                }
                DetectedActivity.ON_BICYCLE -> {
                    Log.e("ActivityRecogition", "On Bicycle: " + activity.getConfidence())
                }
                DetectedActivity.ON_FOOT -> {
                    Log.e("ActivityRecogition", "On Foot: " + activity.getConfidence())
                }
                DetectedActivity.RUNNING -> {
                    Log.e("ActivityRecogition", "Running: " + activity.getConfidence())
                }
                DetectedActivity.STILL -> {
                    if (activity.confidence >= 75) {
                        sendNotification()
                    }
                    Log.e("ActivityRecogition", "Still: " + activity.getConfidence())
                }
                DetectedActivity.TILTING -> {
                    Log.e("ActivityRecogition", "Tilting: " + activity.getConfidence())
                }
                DetectedActivity.WALKING -> {
                    Log.e("ActivityRecogition", "Walking: " + activity.getConfidence())
                    if (activity.confidence >= 75) {
                        sendNotification()
                    }
                }
                DetectedActivity.UNKNOWN -> {
                    Log.e("ActivityRecogition", "Unknown: " + activity.getConfidence())
                }
            }
        }
    }

    private fun sendNotification() {
        val builder = notifcationHelper.getNotificationPrimary("Walking", "Tap to text mom that you're free.")
        val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("smsto", "9192604264", null))
        smsIntent.putExtra("sms_body", "Hey! Amelia is walking and free to talk.\n This message is sent from the ChiamaMamma app.")
        val pendingSmsIntent = PendingIntent.getActivity(applicationContext, 0, smsIntent, 0)
        builder.setContentIntent(pendingSmsIntent)
        NotificationManagerCompat.from(this).notify(0, builder.build())
    }
}