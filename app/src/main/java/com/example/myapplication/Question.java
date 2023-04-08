package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String name;
    private int image;
    private String correctAnswer;
    private ArrayList<String> answers;

    public Question() {}

    public Question(String name, int image, ArrayList<String> answers) {
        this.name = name;
        this.image = image;
        this.answers = answers;
        this.correctAnswer = answers.get(0);
        Collections.shuffle(this.answers);
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }

    public int getImage() {
        return image;
    }

    public Question setImage(int image) {
        this.image = image;
        return this;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Question setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public Question setAnswers(ArrayList<String> answers) {
        this.answers = answers;
        this.correctAnswer = answers.get(0);
        Collections.shuffle(this.answers);
        return this;
    }



    }

