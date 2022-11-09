package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast

class AudioPlayerService: Service() {

    //create a MediaPlayer object to be used to access the phones default ringtone}
    lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    //override the onCreate callback method of the service class

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Service was created", Toast.LENGTH_SHORT).show()
    }

    //override thr onCreate callback method of the service class

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
        player.isLooping = true
        player.start()
        Toast.makeText(this, "Service was Started", Toast.LENGTH_SHORT).show()
        return Service.START_STICKY
        //restart service in the case it was stopped and destroyed/killed
    }
    //Override the onDestroy method of the service class
    override fun onDestroy() {
        super.onDestroy()
            player.stop()
            Toast.makeText(this, "Service being Destroyed", Toast.LENGTH_SHORT).show()
        }
    }



