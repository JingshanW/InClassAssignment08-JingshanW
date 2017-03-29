package com.example.android.inclassassignment08_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference peopleRef = database.getReference("car");
    private ArrayList<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText= (TextView) findViewById(R.id.display_text_view);


        peopleRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                carList.add(dataSnapshot.getValue(Car.class));
                displayPeople();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Car.class) + " has changed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Car.class) + " is removed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

    private void displayPeople() {
        String text = "";
        for (Car c : carList)
            text += c + "\n";
        displayText.setText(text);
    }

    public void add(View view)
    {
        Intent intent=new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
