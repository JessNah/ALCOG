package alcog.alcog;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;




/**
 * Created by Jessica on 9/20/2015.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {

    public static final String ACTION_STOP = "alcog.alcog.ACTION_STOP";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ACTION_STOP)) {
            // stop the mediaplayer

            //Intent intent = new ----
            //intent   maybe register the receiver..

        } else {
            //Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();
            System.out.println("alarm receiver intent was triggered");

            //MediaPlayer mp = playRingTone(Context arg0);
            playRingTone(context);
        }

        // TODO start a service or do something else here?
    }

    private void playRingTone(Context context) {

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
       //AlarmManager alarm1 = AlarmManager.getSystemService(Context.ALARM_SERVICE);
        //ActivityManager arg2 = (ActivityManager)getSystemService(Context.ALARM_SERVICE);
        //AlarmManager arg0 = getSystemService(NewAlarmScreen.class);
        MediaPlayer mp = MediaPlayer.create(context, notification);
        mp.start();

        //getSystemService(Context.VIBRATOR_SERVICE);
        //Vibrator v = (Vibrator) Context.getSystemService(Context.VIBRATOR_SERVICE);
    //v.vibrate(1000);

    }




}

