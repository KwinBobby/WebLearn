package com.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CommonTestActivity extends AppCompatActivity {

    int count;
    int score=0;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_test);
        int position=getIntent().getIntExtra("position",-1);

        final String lessonResult="LessonTestResult"+(position+1);
        sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        final int lessonResultInt=sharedPreferences.getInt(lessonResult,0);


        final TextView question=(TextView)findViewById(R.id.question);
        final TextView rightOption=(TextView)findViewById(R.id.rightOption);
        final RadioButton answer1=(RadioButton) findViewById(R.id.option1);
        final RadioButton answer2=(RadioButton)findViewById(R.id.option2);
        final RadioButton answer3=(RadioButton)findViewById(R.id.option3);
        final RadioButton answer4=(RadioButton)findViewById(R.id.option4);
        final RadioGroup optionMenu=(RadioGroup)findViewById(R.id.optionMenu);
        final ArrayList<QuestionClass> quiz=ListOfQuestions.totalCollection.get(position);
        question.setText(quiz.get(0).getQuestion());
        answer1.setText(quiz.get(0).getOptions().get(0));
        answer2.setText(quiz.get(0).getOptions().get(1));
        answer3.setText(quiz.get(0).getOptions().get(2));
        answer4.setText(quiz.get(0).getOptions().get(3));
        rightOption.setText(String.valueOf(quiz.get(0).getCorrectAnswerIndex()+1));

        count=0;



        final Button next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int chosenAnswerIndex=-1;
                int radioId=optionMenu.getCheckedRadioButtonId();
                optionMenu.clearCheck();
                if(radioId==R.id.option1)
                    chosenAnswerIndex=0;
                else if(radioId==R.id.option2)
                    chosenAnswerIndex=1;
                else if(radioId==R.id.option3)
                    chosenAnswerIndex=2;
                else if(radioId==R.id.option4)
                    chosenAnswerIndex=3;

                if(chosenAnswerIndex==quiz.get(count).getCorrectAnswerIndex())
                    score++;

                count++;

                if(count==quiz.size()-1)
                    next.setText("Done");
                if(count<quiz.size())
                {
                    question.setText(quiz.get(count).getQuestion());
                    answer1.setText(quiz.get(count).getOptions().get(0));
                    answer2.setText(quiz.get(count).getOptions().get(1));
                    answer3.setText(quiz.get(count).getOptions().get(2));
                    answer4.setText(quiz.get(count).getOptions().get(3));
                    rightOption.setText(String.valueOf(quiz.get(count).getCorrectAnswerIndex()+1));

                }
                else if(count==quiz.size())
                {
                    Toast.makeText(getApplicationContext(), String.valueOf(score), Toast.LENGTH_SHORT).show();
                    CommonTestActivity.this.finish();
                    if(score>lessonResultInt)
                        sharedPreferences.edit().putInt(lessonResult,score).apply();
                }


            }
        });

    }

}

