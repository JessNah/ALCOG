
package alcog.alcog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Scanner;


public class Game extends ActionBarActivity {

    private Button nSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 0, y = 0, ans = 0, j = 0; // the two numbers we are adding together
        // read in user input
        Scanner user_input = new Scanner( System.in );

        String an;
        int answer;
        int userAnswer = 0, requirementAnswer = 4;
        while(userAnswer < requirementAnswer){
            x = (int)(Math.random()*9) + 1;
            y = (int)(Math.random()*9) + 1;
            ans = x + y;
            an = Integer.toString(x) + " + " + Integer.toString(y) + " = ";
            System.out.println(an);

            an = user_input.next(); //Number pad entry

            if (Integer.parseInt(an) != ans){
                System.out.println("Wrong");
                requirementAnswer += 1;
            }
            userAnswer += 1;
        }
    }

    */

    nSubmitButton = (Button)findViewById(R.id.submitButton);

    nSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            offAlarmSound();
        }
    });


    private void offAlarmSound(){
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        intent.setAction("ACTION_STOP");
        startActivity(intent);

    }


}



