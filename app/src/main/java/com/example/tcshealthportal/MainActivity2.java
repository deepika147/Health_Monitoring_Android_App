package com.example.tcshealthportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.firebase.database.FirebaseDatabase.*;

public class MainActivity2 extends AppCompatActivity {
    TextView a,b,c,d,e,f;
    Button btn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=(TextView)findViewById(R.id.temparatureview);
        b=(TextView)findViewById(R.id.bloodpressureview);
        c=(TextView)findViewById(R.id.respirationview);
        d=(TextView)findViewById(R.id.glucoseview);
        e=(TextView)findViewById(R.id.heartrateview);
        f=(TextView)findViewById(R.id.oxygenview);
        btn = (Button)findViewById(R.id.click_btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                reff= FirebaseDatabase.getInstance().getReference();
                reff.addValueEventListener(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                        String temparature = dataSnapshot.child("temparature").getValue().toString();
                        String bloodpressure = dataSnapshot.child("bloodpressure").getValue().toString();
                        String respiration = dataSnapshot.child("respiration").getValue().toString();
                        String glucose = dataSnapshot.child("glucose").getValue().toString();
                        String heartrate = dataSnapshot.child("heartrate").getValue().toString();
                        String oxygen = dataSnapshot.child("oxygen").getValue().toString();
                        a.setText(temparature);
                        b.setText(bloodpressure);
                        c.setText(respiration);
                        d.setText(glucose);
                        e.setText(heartrate);
                        f.setText(oxygen);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError){

                    }
                });
            }
        });

    }
}