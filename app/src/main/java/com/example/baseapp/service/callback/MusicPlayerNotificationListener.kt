package com.example.baseapp.service.callback

import android.app.Notification
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.baseapp.service.MusicService
import com.example.baseapp.util.AppConstants
import com.google.android.exoplayer2.ui.PlayerNotificationManager

class MusicPlayerNotificationListener(private val musicService: MusicService) :
  PlayerNotificationManager.NotificationListener {
  override fun onNotificationCancelled(
    notificationId: Int,
    dismissedByUser: Boolean
  ) {
    super.onNotificationCancelled(notificationId, dismissedByUser)
    with(musicService) {
      stopForeground(true)
      isForegroundService = false
      stopSelf()
    }
  }

  override fun onNotificationPosted(
    notificationId: Int,
    notification: Notification,
    ongoing: Boolean
  ) {
    super.onNotificationPosted(notificationId, notification, ongoing)
    with(musicService) {
      if (ongoing && !isForegroundService) {
        ContextCompat.startForegroundService(this, Intent(applicationContext, this::class.java))
        startForeground(AppConstants.NOTIFICATION_ID, notification)
        isForegroundService = true
      }
    }
  }
}