package alcog.alcog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getpebble.android.kit.PebbleKit;

import java.util.UUID;




public class MainActivity extends AppCompatActivity{

    private Button nAddButton;
//    private EditText mAlarmTime;
    public static final UUID PEBBLE_APP_UUID = UUID.fromString("1f1a741c-1181-411c-9b24-86cf5e78a2bb");  //might have to comment outs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcog);

        nAddButton = (Button) findViewById(R.id.addButton);

        nAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playRingTone();   ////////////// uncommentish maybe? my stuff same for below just down now ! !
                addNewAlarm();
            }
        });
    }

    //private void playRingTone(){
        //Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        //MediaPlayer mp = MediaPlayer.create(getApplicationContext(), notification);
        //mp.start();

        //getSystemService(Context.VIBRATOR_SERVICE);
        //Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //v.vibrate(1000);
    //}

    @Override
    protected void onResume() {
        super.onResume();

        boolean isConnected = PebbleKit.isWatchConnected(this);
        Toast.makeText(this, "Pebble " + (isConnected ? "is" : "is not") + " connected!", Toast.LENGTH_LONG).show();
    }

    private void addNewAlarm(){
        Intent intent = new Intent(this,NewAlarmScreen.class);
        startActivity(intent);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alcog, menu);
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

*/
}
