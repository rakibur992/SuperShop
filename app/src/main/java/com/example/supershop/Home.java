package com.example.supershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    ImageView fv, mf, d, c;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_home);
        fv = findViewById(R.id.fruitsVeg);
        mf = findViewById(R.id.meatFish);
        d = findViewById(R.id.dairy);
        c = findViewById(R.id.cooking);

        fv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Home.this, FruitVeg.class));
                }
            }
        });

        mf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Home.this, MeatFish.class));
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Home.this, Cooking.class));
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Home.this, Cooking.class));
                }
            }
        });


    }

    //menu sigout code:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.account:
                System.out.println(mAuth.getUid());
                break;
            case R.id.lout:
                mAuth.signOut();
                startActivity(new Intent(Home.this, MainActivity.class));
                break;
        }
        return true;
    }
}
