import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.deepa.service.R;

/**
 * Created by Deepa on 10/25/2017.
 */

public class Service extends android.app.Service {
    @Nullable
    MediaPlayer mp;
    int pos=0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mp =MediaPlayer.create(getApplicationContext(), R.raw.song);
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(pos==0){mp.start();}
        else{
            mp.start();
            mp.seekTo(pos);}
        mp.setLooping(false);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if(mp.isPlaying()){
            pos=mp.getCurrentPosition();
        }
        mp.pause();
        super.onDestroy();
    }
}