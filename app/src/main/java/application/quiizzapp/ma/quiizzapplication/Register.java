package application.quiizzapp.ma.quiizzapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private static final String TAG = "Register";
    EditText edEmail;
    EditText edPswrdRegister;

    Button bRegister;

    FirebaseAuth mAuth;
    FirebaseUser mAuthUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mAuthUser = mAuth.getCurrentUser();

        edEmail = findViewById(R.id.edEmail);
        edPswrdRegister = findViewById(R.id.edPswrdRegister);

        bRegister = findViewById(R.id.bRegister);


        bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = edEmail.getText().toString().trim();
                String password = edPswrdRegister.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
            Toast.makeText(Register.this, "Un des champs est vide, veuillez vous enregistrer !", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Enter new password", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(email, password).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }
                    }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Register.this, StartQuizz
                                        .class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Register.this, "Sign up Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }



            }
        });


    }
    public void onBackPressed(){
        Intent intent = new Intent(Register.this,Login.class);
        startActivity(intent);
        finish();
    }

}
