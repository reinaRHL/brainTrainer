package com.bt.rena.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button startBtn;
    TextView questionText;
    RelativeLayout inGameLayout;
    int answerLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startBtn = findViewById(R.id.startBtn);
        btn1 = findViewById(R.id.choice1);
        btn2 = findViewById(R.id.choice2);
        btn3 = findViewById(R.id.choice3);
        btn4 = findViewById(R.id.choice4);
        questionText = findViewById(R.id.questionTextView);
        inGameLayout = findViewById(R.id.inGame);
    }

    public void playGame(View view){

        //hide start button
        startBtn.setVisibility(View.INVISIBLE);

        //show game display
        inGameLayout.setVisibility(View.VISIBLE);

        getQuestion();
    }

    public void getQuestion(){

        //generate random numbers for question
        Random rand = new Random();

        // random number between 0~24
        int n1 = rand.nextInt(25);
        int n2 = rand.nextInt(25);
        answerLocation = rand.nextInt(3);
        int answer = n1 + n2;

        questionText.setText(Integer.toString(n1) + "+" + Integer.toString(n2));

        ArrayList<Integer> answerList = new ArrayList<>();

        //generate random answers
        for (int i=0; i<4; i++){
            if (i != answerLocation){
                int wrongAnswer = rand.nextInt(60);
                while (wrongAnswer == answer){
                    wrongAnswer = rand.nextInt(60);
                }
            answerList.add(i, wrongAnswer);
            }
            else{
                answerList.add(answerLocation, answer);
            }
        }

        //display buttons
        btn1.setText(Integer.toString(answerList.get(0)));
        btn2.setText(Integer.toString(answerList.get(1)));
        btn3.setText(Integer.toString(answerList.get(2)));
        btn4.setText(Integer.toString(answerList.get(3)));


        //add timer here 30s
        //on tick- update timer display
        //on finish- reset all the value, display the result update timer to "" , make 'play again button' visible
    }

    public void answerChosen(View view){
        //check if selected answer is correct

        //if correct: add score, display 'correct'
        //if not: display 'wrong!"

        //for both cases, number of question increses
        // next question should be generated

        getQuestion();
    }

}
