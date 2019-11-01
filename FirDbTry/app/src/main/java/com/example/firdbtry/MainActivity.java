package com.example.firdbtry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Switch s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        final DatabaseReference myRef1 = fdb.getReference("Light1");
        final DatabaseReference myRef2 = fdb.getReference("Light2");
        final DatabaseReference myRef3 = fdb.getReference("Light3");
        s1 = (Switch) findViewById(R.id.switch1);
        s2 = (Switch) findViewById(R.id.switch2);
        s3 = (Switch) findViewById(R.id.switch3);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s1.isChecked())
                {
                    //Toast.makeText(MainActivity.this,"Switched On",Toast.LENGTH_SHORT).show();
                    myRef1.setValue("On");
                }
                else
                {
                    //Toast.makeText(MainActivity.this,"Switched Off",Toast.LENGTH_SHORT).show();
                    myRef1.setValue("Off");
                }
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s2.isChecked())
                {
                    //Toast.makeText(MainActivity.this,"Switched On",Toast.LENGTH_SHORT).show();
                    myRef2.setValue("On");
                }
                else
                {
                    //Toast.makeText(MainActivity.this,"Switched Off",Toast.LENGTH_SHORT).show();
                    myRef2.setValue("Off");
                }
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s3.isChecked())
                {
                   // Toast.makeText(MainActivity.this,"Switched On",Toast.LENGTH_SHORT).show();
                    myRef3.setValue("On");
                }
                else
                {
                   // Toast.makeText(MainActivity.this,"Switched Off",Toast.LENGTH_SHORT).show();
                    myRef3.setValue("Off");
                }
            }
        });
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this,val,Toast.LENGTH_SHORT).show();
                if(val.equals("On"))
                    s1.setChecked(true);
                else
                    s1.setChecked(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this,val,Toast.LENGTH_SHORT).show();
                if(val.equals("On"))
                    s2.setChecked(true);
                else
                    s2.setChecked(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this,val,Toast.LENGTH_SHORT).show();
                if(val.equals("On"))
                    s3.setChecked(true);
                else
                    s3.setChecked(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
