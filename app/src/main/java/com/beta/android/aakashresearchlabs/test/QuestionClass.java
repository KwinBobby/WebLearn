package com.beta.android.aakashresearchlabs.test;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/25/2017.
 */

public class QuestionClass {

    private String question;
    private int correctAnswerIndex;
    private ArrayList<String> options;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }



}
