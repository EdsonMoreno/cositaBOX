package com.edsonmoreno.cositabox;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    private MediaPlayer miRepro;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        miRepro = MediaPlayer.create(this,R.raw.cancion);
        miRepro.setLooping(true);
        miRepro.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        miRepro.start();
       // return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(miRepro.isPlaying()) miRepro.stop();
        miRepro.release();
        miRepro = null;

    }
}
