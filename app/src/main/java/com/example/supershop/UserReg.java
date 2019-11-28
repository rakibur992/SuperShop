package com.example.supershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserReg extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button signUpBtn;
    EditText email,pass0,pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        mAuth=FirebaseAuth.getInstance();
        signUpBtn=findViewById(R.id.btn_sigup);
        email=findViewById(R.id.email);
        pass0=findViewById(R.id.pass0);
        pass1=findViewById(R.id.pass1);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eml = email.getText().toString();
                String pass2 = pass0.getText().toString();
                String pass3 = pass1.getText().toString();

                if (eml.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass2.equals(pass3)){
                    Toast.makeText(getApplicationContext(), "Enter password / Password Dont Match ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    //create user
                    signUp(eml,pass3);
                }

            }
        });
    }

    void signUp(String email,String pass3){
        mAuth.createUserWithEmailAndPassword(email,pass3).addOnCompleteListener(UserReg.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(UserReg.this, "Sign Up Fail" + task.getException(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(UserReg.this, Home.class));

                }

            }
        });

    }
}
