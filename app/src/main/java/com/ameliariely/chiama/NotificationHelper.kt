package com.ameliariely.chiama

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.support.v4.app.NotificationCompat


/**
Inspired by {@linktourl https://github.com/googlesamples/android-NotificationChannels/blob/master/Application/src/main/java/com/example/android/notificationchannels/NotificationHelper.java}
 */

class NotificationHelper(context: Context) : ContextWrapper(context) {

    private var manager: NotificationManager? = null
    val PRIMARY_CHANNEL = "default"

    init {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // The user-visible name of the channel.
            val name = getString(R.string.walking_channel)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(PRIMARY_CHANNEL, name, importance)
            mChannel.setShowBadge(false)
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
        }
    }

    /**
     * Send a notification.
     *
     * @param id The ID of the notification
     * @param notification The notification object
     */
    fun notify(id: Int, notification: NotificationCompat.Builder) {
        //TODO do something if getManager returns null
        getManager()?.notify(id, notification.build())
    }

    /**
     * Get a notification of type primary
     *
     * Provide the builder rather than the notification it's self as useful for making notification
     * changes.
     *
     * @param title the title of the notification
     * @param body the body text for the notification
     * @return the builder as it keeps a reference to the notification (since API 24)
     */
    fun getNotificationPrimary(title: String, body: String): NotificationCompat.Builder {
        return NotificationCompat.Builder(applicationContext, PRIMARY_CHANNEL)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
    }


    /**
     * Get the notification manager.
     *
     * Utility method as this helper works with it a lot.
     *
     * @return The system service NotificationManager
     */
    private fun getManager(): NotificationManager? {
        if (manager == null) {
            manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        return manager
    }
}
