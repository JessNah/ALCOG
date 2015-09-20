package alcog.alcog;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.Scanner;


public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

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

            System.out.println("What is the answer? ");
            an = user_input.next(); //Number pad entry

            if (Integer.parseInt(an) != ans){
                System.out.println("Wrong");
                requirementAnswer += 1;
            }
            userAnswer += 1;
        }
    }
}
