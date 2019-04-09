package application.quiizzapp.ma.quiizzapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emredavarci.circleprogressbar.CircleProgressBar;

public class ResultatActivity extends AppCompatActivity {
   private TextView textResultat;
    private CircleProgressBar circleProgressBar;
    private int score_finale;
    private Button bLocalisation;
    private Button bPlayAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);



        bLocalisation = findViewById(R.id.bLocalisation);
        bPlayAgain = findViewById(R.id.bPlayAgain);

        //intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score_finale = extras.getInt("scorefinal");
        }
        score_finale = scoreFinalePercent(score_finale);

        textResultat = findViewById(R.id.textResult);
        textResultat.setText(score_finale + " %");
        circleProgressBar = findViewById(R.id.circle);
        circleProgressBar.setProgress(score_finale);

        bPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultatActivity.this, StartQuizz.class);
                startActivity(intent);
            }
        });

        bLocalisation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              //      Intent intent = new Intent(ResultatActivity.this, LocateActivity.class);
              //      startActivity(intent);

                       }
        });


    }


    private int scoreFinalePercent(int a){
        switch (a) {
            case 0:
                score_finale = 0;
                break;
            case 1:
                score_finale = 20;
                break;
            case 2:
                score_finale = 40;
                break;
            case 3:
                score_finale = 60;
                break;
            case 4:
                score_finale = 80;
                break;
            case 5:
                score_finale = 100;
                break;
            default:
                score_finale = 0;
        }
        return score_finale;
    }
    }



