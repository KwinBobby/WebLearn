package com.beta.android.aakashresearchlabs.test;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/25/2017.
 */

//Contains all the questions for the app

public class ListOfQuestions {

    ArrayList<String> answers;
    ArrayList<QuestionClass> singlequiz;
    static ArrayList<ArrayList<QuestionClass>> totalCollection;
    QuestionClass QandA=new QuestionClass();
    // ArrayList<ArrayList<HashMap<String,ArrayList<String>>>> quizCollection;

    public void fillquestion()
    {
        answers=new ArrayList<>();
        singlequiz=new ArrayList<>();
        totalCollection=new ArrayList<>();

        fillup("What is your name?","answer1","answer2","answer3","answer4",0);
        fillup("What is your name?2","answer5","answer6","answer7","answer8",2);
        fillup("What is your name?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);
        singlequiz=new ArrayList<>();
        fillup("What is your pet?","answer1","answer2","answer3","answer4",1);
        fillup("What is your pet?2","answer5","answer6","answer7","answer8",2);
        fillup("What is your pet?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("What is your zoo?","answer1","answer2","answer3","answer4",1);
        fillup("What is your zoo?2","answer5","answer6","answer7","answer8",2);
        fillup("What is your zoo?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("What is your kiki?","answer1","answer2","answer3","answer4",1);
        fillup("What is your kiki?2","answer5","answer6","answer7","answer8",2);
        fillup("What is your kiki?3","answer9","answer10","answer11","answer12",1);
        fillup("What is your kiki?4","answer9","answer10","answer11","answer12",0);
        fillup("What is your kiki?5","answer9","answer10","answer11","answer12",3);

        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("Who is taakuu?","answer1","answer2","answer3","answer4",1);
        fillup("Who is taakuu?2","answer5","answer6","answer7","answer8",2);
        fillup("Who is taakuu?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("How do you say bottle?","answer1","answer2","answer3","answer4",1);
        fillup("How do you say bottle?2","answer5","answer6","answer7","answer8",2);
        fillup("How do you say bottle?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);


        singlequiz=new ArrayList<>();
        fillup("Kya khaaya?","answer1","answer2","answer3","answer4",1);
        fillup("Kya khaaya?2","answer5","answer6","answer7","answer8",2);
        fillup("Kya khaaya?3","answer9","answer10","answer11","answer12",1);

        totalCollection.add(singlequiz);


    }

    void fillup(String question, String answer1,String answer2,String answer3,String answer4,int correctAnswerIndex)
    {
        QandA=new QuestionClass();
        answers=new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        QandA.setQuestion(question);
        QandA.setOptions(answers);
        QandA.setCorrectAnswerIndex(correctAnswerIndex);
        singlequiz.add(QandA);
    }


}
