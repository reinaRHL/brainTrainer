package com.bt.rena.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button startBtn;
    TextView questionText;
    RelativeLayout inGameLayout;

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
        startBtn.setVisibility(View.INVISIBLE);
        inGameLayout.setVisibility(View.VISIBLE);
        getQuestion();
    }

    public void getQuestion(){

        //generate random question
        questionText.setText("test");
        //calculate the answer
        //generate random answers
        //put it in the list
        //display


        //add timer here 30s
        //on tick- update timer display
        //on finish- reset all the value, display the result update timer to "" , make 'play again button' visible
    }

    public void answerChosen(View view){
        //check if selected answer is correc

        //if correct: add score, display 'correct'
        //if not: display 'wrong!"

        //for both cases, number of question increses
        // next question should be generated

        getQuestion();
    }

}
