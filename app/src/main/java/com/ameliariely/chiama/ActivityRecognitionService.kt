package com.ameliariely.chiama

import android.app.IntentService
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import com.google.android.gms.location.ActivityRecognitionResult
import com.google.android.gms.location.DetectedActivity


class ActivityRecognitionService : IntentService {

    private lateinit var notifcationHelper : NotificationHelper

    constructor() : super("ActivityRecognitionService")

    constructor(name: String) : super(name)

    override fun onCreate() {
        super.onCreate()
        notifcationHelper = NotificationHelper(applicationContext)
    }

    override fun onHandleIntent(intent: Intent?) {
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
        NotificationManagerCompat.from(this).notify(0, builder.build())
    }
}