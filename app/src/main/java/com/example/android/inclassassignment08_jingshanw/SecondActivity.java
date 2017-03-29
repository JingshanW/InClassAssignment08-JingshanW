package com.example.android.inclassassignment08_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference carRef = database.getReference("car");

    private TextView brand;
    private TextView price;
    private CheckBox suv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        brand= (TextView) findViewById(R.id.brand_text_view);
        price= (TextView) findViewById(R.id.price_text_view);
        suv= (CheckBox) findViewById(R.id.suv_checkbox);
    }

    public void addToFirebase(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        String b=brand.getText().toString();
        int p=Integer.parseInt(price.getText().toString());
        boolean s=suv.isChecked();
        carRef.push().setValue(new Car(b,s,p));

        Car car=new Car(b,s,p);
        startActivity(intent);
    }
}
