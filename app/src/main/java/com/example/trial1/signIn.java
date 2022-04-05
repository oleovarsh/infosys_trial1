package com.example.trial1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signIn extends AppCompatActivity {
    EditText edtName, edtTelehandle;
    Button submitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtName=findViewById(R.id.enter_username);
        edtTelehandle=findViewById(R.id.enter_telehandle);
        submitLogin=findViewById(R.id.submitlogin);

        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference login_table=database.getReference("User");

        submitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog mDialog= new ProgressDialog(signIn.this);
                mDialog.setMessage("wait");
                mDialog.show();

                login_table.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.child(edtName.getText().toString()).exists()){
                            mDialog.dismiss();
                            User user= snapshot.child(edtName.getText().toString()).getValue(User.class);



                            if(user.getTelehandle().equals(edtTelehandle.getText().toString())){
                                Toast.makeText(signIn.this,"success",Toast.LENGTH_SHORT).show();
                                Intent add_req= new Intent(signIn.this,MainActivity2.class);
                                startActivity(add_req);

                            }

                            else{
                                Toast.makeText(signIn.this,"fail",Toast.LENGTH_SHORT).show();

                            }

                        }

                        else{
                            mDialog.dismiss();
                            User user= new User(edtTelehandle.getText().toString());
                            login_table.child(edtName.getText().toString()).setValue(user);
                            Toast.makeText(signIn.this,"added",Toast.LENGTH_SHORT).show();


                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });
            }
        });


    }
}