package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button add_Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signinIntent=new Intent(MainActivity.this,signIn.class);
                startActivity(signinIntent);
            }
        });

        add_Req=findViewById(R.id.add_request);


        add_Req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reqIntent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(reqIntent);
            }
        });
    }
}