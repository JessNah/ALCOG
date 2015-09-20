package alcog.alcog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.Calendar;


public class NewAlarmScreen extends ActionBarActivity {

    TimePicker tp = null;

    private NumberPicker nHourPicker;
    //nHourPicker = (NumberPicker) findViewById(R.id.hourPicker);
    //((hourPicker) view).setMaxValue(24);
    private Button nSetAlarmButton;
    private static final int KEY_ONE_DATA = 6;
    private String hourString;
    private String minuteString;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm_screen);


        nSetAlarmButton = (Button) findViewById(R.id.setAlarmButton);

        nSetAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        tp = (TimePicker) findViewById(R.id.timePicker);
        hour = tp.getCurrentHour();
        minute = tp.getCurrentMinute();
        hourString = "" + hour;
        minuteString = "" + minute;


                /////////
                Calendar current = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                System.out.println("Hour and minute:   " + hour + " " + minute);
                cal.set(2015,8,20,hour,minute,00);  //hardcCalendar current = Calendar.getInstance();   //day started at 0
                System.out.println("I am considering: " + cal + " and " + current);

                if(cal.compareTo(current) < 0){
                    //The set Date/Time already passed
                    Toast.makeText(getApplicationContext(),
                            "Invalid Date/Time",
                            Toast.LENGTH_LONG).show();
                }else{
                    setAlarmSound(cal);
                };
                ////////////



        PebbleDictionary data = new PebbleDictionary();
        data.addString(KEY_ONE_DATA, hourString);
        data.addString(KEY_ONE_DATA, minuteString);
        PebbleKit.sendDataToPebble(getApplicationContext(), MainActivity.PEBBLE_APP_UUID, data);

        PebbleKit.registerReceivedAckHandler(getApplicationContext(), new PebbleKit.PebbleAckReceiver(MainActivity.PEBBLE_APP_UUID) {

            @Override
            public void receiveAck(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received ack for transaction " + transactionId);
            }

        });

        PebbleKit.registerReceivedNackHandler(getApplicationContext(), new PebbleKit.PebbleNackReceiver(MainActivity.PEBBLE_APP_UUID) {

            @Override
            public void receiveNack(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received nack for transaction " + transactionId);
            }

        });


                setAlarm();
            }
        });
    }

    private void setAlarm(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



    //////////////
    private void setAlarmSound(Calendar targetCal){
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

Calendar c = Calendar.getInstance();
        int utcOffset = c.get(Calendar.ZONE_OFFSET) + c.get(Calendar.DST_OFFSET);
        //int offsetToUse = 13720000;

//        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        long nowSoon =         c.getTimeInMillis() + 1000;
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);


        System.out.println("set for this time: " + targetCal.getTimeInMillis() + " utcOffset: " + utcOffset);   // + " utcOffset: + utcOffset"

    }

    //////////////////



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_alarm_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
