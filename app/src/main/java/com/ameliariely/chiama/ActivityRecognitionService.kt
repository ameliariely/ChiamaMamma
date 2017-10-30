package com.ameliariely.chiama

import android.content.Intent
import android.app.IntentService
import android.util.Log
import com.google.android.gms.location.ActivityRecognitionResult
import com.google.android.gms.location.DetectedActivity
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.NotificationCompat


class ActivityRecognitionService : IntentService {

    constructor() : super("ActivityRecognitionService") {}

    constructor(name: String) : super(name) {}

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
                    Log.e("ActivityRecogition", "Still: " + activity.getConfidence())
                }
                DetectedActivity.TILTING -> {
                    Log.e("ActivityRecogition", "Tilting: " + activity.getConfidence())
                }
                DetectedActivity.WALKING -> {
                    Log.e("ActivityRecogition", "Walking: " + activity.getConfidence())
                    if (activity.confidence >= 75) {
                        val builder = NotificationCompat.Builder(this)
                        builder.setContentText("Are you walking?")
                        builder.setSmallIcon(R.mipmap.ic_launcher)
                        builder.setContentTitle(getString(R.string.app_name))
                        NotificationManagerCompat.from(this).notify(0, builder.build())
                    }
                }
                DetectedActivity.UNKNOWN -> {
                    Log.e("ActivityRecogition", "Unknown: " + activity.getConfidence())
                }
            }
        }
    }
}