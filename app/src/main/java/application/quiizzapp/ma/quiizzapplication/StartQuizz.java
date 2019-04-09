package application.quiizzapp.ma.quiizzapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class StartQuizz extends AppCompatActivity {
    private DatabaseReference mDatabase;

    private Button answer1, answer2, answer3;
    private TextView score, question;

    private Questions mQuestion = new Questions();

    private String mAnswer;
    public int mScore = 0;
    private int mQuestionsNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quizz);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Question1");



        answer1 = findViewById(R.id.bAnswer1);
        answer2 = findViewById(R.id.bAnswer2);
        answer3 = findViewById(R.id.bAnswer3);

        question = findViewById(R.id.tvQuestion);
        score = findViewById(R.id.score);
        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    Toast.makeText(StartQuizz.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                } else {
                    Toast.makeText(StartQuizz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(StartQuizz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StartQuizz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(StartQuizz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StartQuizz.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });


    }


    private void updateScore(int point) {
        score.setText("" + mScore);
    }


    private void updateQuestion() {
        if (mQuestionsNumber < 5) {
            question.setText(mQuestion.getQuestion(mQuestionsNumber));
            answer1.setText(mQuestion.getChoice1(mQuestionsNumber));
            answer2.setText(mQuestion.getChoice2(mQuestionsNumber));
            answer3.setText(mQuestion.getChoice3(mQuestionsNumber));

            mAnswer = mQuestion.getCorrectAnswer(mQuestionsNumber);
            mQuestionsNumber++;
        } else {
            Intent i1 = new Intent(this, ResultatActivity.class);
            i1.putExtra("scorefinal", mScore);
            startActivity(i1);
        }
    }
    public int getmScore(){
        return mScore;
    }

}

