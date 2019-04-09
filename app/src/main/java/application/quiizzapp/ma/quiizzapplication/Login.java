package application.quiizzapp.ma.quiizzapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
     EditText login, passwordLogin;
     Button bLogin;
     TextView register;
     FirebaseAuth mAuth;
     FirebaseUser mAuthUser;
     FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.edLogin);
        passwordLogin = findViewById(R.id.edPassword);
        bLogin = findViewById(R.id.bLogin);
        register = findViewById(R.id.tvRegister);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = login.getText().toString().trim();
                String password = passwordLogin.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this,"Veuillez entrer votre email",Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.signInWithEmailAndPassword(email,password).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(Login.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();

                        }
                    }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent=new Intent(Login.this,StartQuizz.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(Login.this,"Sign in Failed",Toast.LENGTH_SHORT).show();
                            }
                        }});

                }

            }
        });





        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                    if(firebaseAuth.getCurrentUser() != null){
                        startActivity(new Intent(Login.this, StartQuizz.class));
                    }
            }
        };



    }



}