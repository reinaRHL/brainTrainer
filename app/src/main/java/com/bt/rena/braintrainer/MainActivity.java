package com.bt.rena.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button startBtn;
    Button playAgainBtn;
    TextView questionText;
    TextView resultView;
    TextView timeView;
    TextView finalResultTextView;
    RelativeLayout inGameLayout;
    RelativeLayout resultLayout;
    Toast toastMsg;
    int answerLocation;
    int totalScore = 0;
    int numQuestions = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get necessary objects from the view
        startBtn = findViewById(R.id.startBtn);
        btn1 = findViewById(R.id.choice1);
        btn2 = findViewById(R.id.choice2);
        btn3 = findViewById(R.id.choice3);
        btn4 = findViewById(R.id.choice4);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        questionText = findViewById(R.id.questionTextView);
        inGameLayout = findViewById(R.id.inGame);
        resultLayout = findViewById(R.id.resultLayout);
        resultView = findViewById(R.id.resultTextView);
        timeView = findViewById(R.id.timeTextView);
        finalResultTextView = findViewById(R.id.finalResultTextView);
        resultLayout.setVisibility(View.INVISIBLE);
        inGameLayout.setVisibility(View.INVISIBLE);
    }

    public void playGame(View view){

        //hide start button, playagain btn, and resultLayout
        startBtn.setVisibility(View.INVISIBLE);
        resultLayout.setVisibility(View.INVISIBLE);

        //show game display
        inGameLayout.setVisibility(View.VISIBLE);
        resultView.setText("0/0");
        //add timer here 30s
        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long l) {
                timeView.setText(Long.toString(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                timeView.setText("0s");
                inGameLayout.setVisibility(View.INVISIBLE);
                resultLayout.setVisibility(View.VISIBLE);
                finalResultTextView.setText(Integer.toString(totalScore) + "/" + Integer.toString(numQuestions));
                totalScore = 0;
                numQuestions =0;

            }
        }.start();

        getQuestion();

    }

    public void getQuestion(){

        // generate random numbers to make a question
        Random rand = new Random();

        // random number between 0~24
        int n1 = rand.nextInt(25);
        int n2 = rand.nextInt(25);
        answerLocation = rand.nextInt(3);

        //answer for addition
        int answer = n1 + n2;

        // display random question to the screen
        questionText.setText(Integer.toString(n1) + "+" + Integer.toString(n2));

        ArrayList<Integer> answerList = new ArrayList<>();

        //generate random answers
        for (int i = 0; i < 4; i++){
            if (i != answerLocation){
                int wrongAnswer = rand.nextInt(60);
                while (wrongAnswer == answer){
                    wrongAnswer = rand.nextInt(60);
                }
            answerList.add(i, wrongAnswer);
            }
            else{
                // correct answer
                answerList.add(answerLocation, answer);
            }
        }

        //display buttons
        btn1.setText(Integer.toString(answerList.get(0)));
        btn2.setText(Integer.toString(answerList.get(1)));
        btn3.setText(Integer.toString(answerList.get(2)));
        btn4.setText(Integer.toString(answerList.get(3)));

    }

    public void answerChosen(View view){

        numQuestions++;

        //check if selected answer is correct
        int selected = Integer.parseInt(view.getTag().toString());
        if (selected == answerLocation) {
            toastMsg = Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT);
            totalScore++;
        }
        else{
            toastMsg = Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT);
        }
        toastMsg.show();
        resultView.setText(Integer.toString(totalScore) + "/" + Integer.toString(numQuestions));

        getQuestion();
    }

}
