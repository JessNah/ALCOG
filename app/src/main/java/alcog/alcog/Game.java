
package alcog.alcog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;


public class Game extends ActionBarActivity {

    private Button nSubmitButton;
    private TextView question;
    private EditText answertext;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


        int x = 6;
        int y = 3;
        int ans = 9; // the two numbers we are adding together
        // read in user input
        Scanner user_input = new Scanner( System.in );

        String an;
        int answer;


            question.setText("6 + 3 = ?");

            //System.out.println(an);

            answertext = (EditText)findViewById(R.id.textAnswer);
            String correction = Integer.toString(answer);

            if(correction.equals((Integer.toString(ans)))){
                flag = 1;
            }

             //an = user_input.next(); //Number pad entry

//            if (Integer.parseInt(an) != ans){
//                System.out.println("Wrong");
//                requirementAnswer += 1;
//            }


    nSubmitButton = (Button)findViewById(R.id.submitButton);

    nSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(flag==1){
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



