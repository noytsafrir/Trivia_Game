package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Activity_Game extends AppCompatActivity {

    ArrayList<Question> questions = new ArrayList<>();

    private AppCompatImageView[] game_IMG_coins;

    private AppCompatImageView game_IMG_coin1;
    private AppCompatImageView game_IMG_coin2;
    private AppCompatImageView game_IMG_coin3;
    private AppCompatImageView game_IMG_coin4;
    private AppCompatImageView game_IMG_coin5;
    private AppCompatImageView game_IMG_coin6;
    private AppCompatImageView game_IMG_coin7;
    private AppCompatImageView game_IMG_coin8;
    private AppCompatImageView game_IMG_coin9;
    private AppCompatImageView game_IMG_coin10;
    private AppCompatImageView game_IMG_question;
    private MaterialButton game_BTN_answer1;
    private MaterialButton game_BTN_answer2;
    private MaterialButton game_BTN_answer3;
    private MaterialButton game_BTN_answer4;
    private MaterialButton game_BTN_playAgain;

    private int coins = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        startViews();
        initViews();
        initQuestions();
        startNewGame();
    }

    private void startNewGame(){
        Collections.shuffle(this.questions);
        game_BTN_playAgain.setVisibility(View.GONE);
        coins = 0;
        index = 0;
        game_BTN_answer1.setVisibility(View.VISIBLE);
        game_BTN_answer2.setVisibility(View.VISIBLE);
        game_BTN_answer3.setVisibility(View.VISIBLE);
        game_BTN_answer4.setVisibility(View.VISIBLE);
        updateUI();
    }

    private void initQuestions() {
        questions.add(new Question().setName("The lion king").setImage(R.drawable.img_the_lion_king).
                setAnswers(new ArrayList<String>(Arrays.asList("The Lion King", "Toy Story", "The Jungle Book", "Beauty And The Beast"))));
        questions.add(new Question().setName("The jungle book").setImage(R.drawable.img_the_jungle_book).
                setAnswers(new ArrayList<String>(Arrays.asList("The Jungle Book", "Aladin", "Tarzan", "The Lion King"))));
        questions.add(new Question().setName("Frozen").setImage(R.drawable.img_frozen).
                setAnswers(new ArrayList<String>(Arrays.asList("Frozen", "Rapunzel", "Snow White", "The Little Mermaid"))));
        questions.add(new Question().setName("Dambo").setImage(R.drawable.img_dambo).
                setAnswers(new ArrayList<String>(Arrays.asList("Dambo", "Peter Pan", "Toy Story", "Mary Poppins"))));
        questions.add(new Question().setName("Peter pan").setImage(R.drawable.img_peter_pan).
                setAnswers(new ArrayList<String>(Arrays.asList("Peter Pan", "Aladin", "Frozen", "Mary Poppins"))));
        questions.add(new Question().setName("Lilo and Stitch").setImage(R.drawable.img_lilo_and_stitch).
                setAnswers(new ArrayList<String>(Arrays.asList("Lilo And Stitch", "Monsters Inc", "Bambi", "Beauty and the beast"))));
        questions.add(new Question().setName("Aladin").setImage(R.drawable.img_aladin).
                setAnswers(new ArrayList<String>(Arrays.asList("Aladin", "Monsters Inc", "Cinderella", "Beauty and the beast"))));
        questions.add(new Question().setName("The little mermaid").setImage(R.drawable.img_the_little_mermaid).
                setAnswers(new ArrayList<String>(Arrays.asList("The Little Mermaid", "Bambi", "Find Nemo", "Lilo and Stitch"))));
        questions.add(new Question().setName("Monsters inc").setImage(R.drawable.img_inc_monsters).
                setAnswers(new ArrayList<String>(Arrays.asList("Monsters Inc", "Cinderella", "Find Nemo", "Lilo and Stitch"))));
        questions.add(new Question().setName("Bambi").setImage(R.drawable.img_bambi).
                setAnswers(new ArrayList<String>(Arrays.asList("Bambi", "Dambo", "Snow white", "The Jungle Book"))));
    }

    private void clicked(int answer) {
        Question question = questions.get(index);
        String theAnswer = question.getAnswers().get(answer-1);
        if (theAnswer.equals(question.getCorrectAnswer()))
            addCoin();
        next();
    }

    private void next() {
        index++;
        if(hasNext()){
            updateUI();
        }
        else {
            refreshCoinsUI();
            gameOver();
        }
    }

    private void gameOver() {
        Toast.makeText(this, "Game Over" , Toast.LENGTH_LONG).show();
        game_BTN_answer1.setVisibility(View.INVISIBLE);
        game_BTN_answer2.setVisibility(View.INVISIBLE);
        game_BTN_answer3.setVisibility(View.INVISIBLE);
        game_BTN_answer4.setVisibility(View.INVISIBLE);
        game_IMG_question.setImageResource(R.drawable.img_game_over);
        game_BTN_playAgain.setVisibility(View.VISIBLE);
    }

    private boolean hasNext() {
        return index < questions.size();
    }

    private void updateUI() {
        refreshCoinsUI();
        Question question = questions.get(index);
        game_IMG_question.setImageResource(question.getImage());
        updateAnswers(question);
    }

    private void addCoin(){
        coins++;
    }

    private void refreshCoinsUI() {
        for (int i = 0; i < coins; i++) {
            game_IMG_coins[i].setVisibility(View.VISIBLE);
        }
        for (int i = coins; i < 10; i++) {
            game_IMG_coins[i].setVisibility(View.INVISIBLE);
        }
    }

    private void updateAnswers(Question question) {
        game_BTN_answer1.setText(question.getAnswers().get(0));
        game_BTN_answer2.setText(question.getAnswers().get(1));
        game_BTN_answer3.setText(question.getAnswers().get(2));
        game_BTN_answer4.setText(question.getAnswers().get(3));
    }

    private void initViews() {
        game_BTN_answer1.setOnClickListener(v -> clicked(1));
        game_BTN_answer2.setOnClickListener(v -> clicked(2));
        game_BTN_answer3.setOnClickListener(v -> clicked(3));
        game_BTN_answer4.setOnClickListener(v -> clicked(4));
        game_BTN_playAgain.setOnClickListener(v -> startNewGame());
    }

    private void startViews() {
        game_IMG_coin1 = findViewById(R.id.game_IMG_coin1);
        game_IMG_coin2 = findViewById(R.id.game_IMG_coin2);
        game_IMG_coin3 = findViewById(R.id.game_IMG_coin3);
        game_IMG_coin4 = findViewById(R.id.game_IMG_coin4);
        game_IMG_coin5 = findViewById(R.id.game_IMG_coin5);
        game_IMG_coin6 = findViewById(R.id.game_IMG_coin6);
        game_IMG_coin7 = findViewById(R.id.game_IMG_coin7);
        game_IMG_coin8 = findViewById(R.id.game_IMG_coin8);
        game_IMG_coin9 = findViewById(R.id.game_IMG_coin9);
        game_IMG_coin10 = findViewById(R.id.game_IMG_coin10);

        game_BTN_answer1 = findViewById(R.id.game_BTN_answer1);
        game_BTN_answer2 = findViewById(R.id.game_BTN_answer2);
        game_BTN_answer3 = findViewById(R.id.game_BTN_answer3);
        game_BTN_answer4 = findViewById(R.id.game_BTN_answer4);
        game_IMG_question = findViewById(R.id.game_IMG_question);

        game_BTN_playAgain = findViewById(R.id.game_BTN_playAgain);

        game_IMG_coins = new AppCompatImageView[]{
                game_IMG_coin1,
                game_IMG_coin2,
                game_IMG_coin3,
                game_IMG_coin4,
                game_IMG_coin5,
                game_IMG_coin6,
                game_IMG_coin7,
                game_IMG_coin8,
                game_IMG_coin9,
                game_IMG_coin10,
        };

    }
}